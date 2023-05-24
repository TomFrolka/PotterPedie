package com.tf.potterpedie.di

import com.google.gson.GsonBuilder
import com.tf.potterpedie.data.characters.network.CharactersNetworkDataSource
import com.tf.potterpedie.data.characters.network.ICharactersNetworkDataSource
import com.tf.potterpedie.data.characters.network.ICharactersNetworkService
import com.tf.potterpedie.domain.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder()
            .baseUrl(Constants.HP_API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptors: List<Interceptor>): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
        interceptors.forEach {
            builder.addInterceptor(it)
        }
        builder.readTimeout(Constants.API_TIMEOUT, TimeUnit.SECONDS)
        builder.writeTimeout(Constants.API_TIMEOUT, TimeUnit.SECONDS)
        builder.connectTimeout(Constants.API_TIMEOUT, TimeUnit.SECONDS)
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideCharactersNetworkService(retrofit: Retrofit): ICharactersNetworkService =
        retrofit.create(ICharactersNetworkService::class.java)

    @Singleton
    @Provides
    fun provideCharactersNetworkDataSource(characterNetworkService: ICharactersNetworkService): ICharactersNetworkDataSource =
        CharactersNetworkDataSource(characterNetworkService)


}