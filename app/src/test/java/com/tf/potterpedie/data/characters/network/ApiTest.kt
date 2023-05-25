package com.tf.potterpedie.data.characters.network

import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiTest {

    private lateinit var charactersApi: ICharactersNetworkService
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setup(){
        mockWebServer = MockWebServer()
        charactersApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ICharactersNetworkService::class.java)
    }

    private fun readResponseFile(): String? {
        val inputStream = this::class.java.getResourceAsStream("/response.json")
        return inputStream?.source()?.buffer()?.readString(Charsets.UTF_8)
    }

    @Test
    fun testGetAllCharacters() = runBlocking{
        val mockResponse = MockResponse()
        mockResponse.setBody("[]")
        mockWebServer.enqueue(mockResponse)
        val response = charactersApi.getAllCharacters()
        mockWebServer.takeRequest()
        Assert.assertEquals(true, response.body()!!.isEmpty())
    }

    @Test
    fun testGetAllCharacters_returnCharacters() = runBlocking{
        val mockResponse = MockResponse()
        val content = readResponseFile()
        Assert.assertEquals(true, content?.isNotEmpty())
        mockResponse.setResponseCode(200)
        mockResponse.setBody(content!!)
        mockWebServer.enqueue(mockResponse)

        val response = charactersApi.getAllCharacters()
        mockWebServer.takeRequest()

        Assert.assertEquals(false, response.body()!!.isEmpty())
        Assert.assertEquals(2, response.body()!!.size)
    }

    @Test
    fun testGetAllCharacters_returnError() = runBlocking{
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(404)
        mockResponse.setBody("Something went wrong")
        mockWebServer.enqueue(mockResponse)

        val response = charactersApi.getAllCharacters()
        mockWebServer.takeRequest()

        Assert.assertEquals(false, response.isSuccessful)
        Assert.assertEquals(404, response.code())
    }

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }
}