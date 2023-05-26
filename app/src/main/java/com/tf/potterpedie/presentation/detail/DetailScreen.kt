package com.tf.potterpedie.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.tf.potterpedie.R
import com.tf.potterpedie.domain.characters.model.HPCharacter
import com.tf.potterpedie.domain.characters.model.Wand
import com.tf.potterpedie.presentation.components.DetailEntry
import com.tf.potterpedie.presentation.components.NavigationButton
import com.tf.potterpedie.presentation.theme.PotterpedieTheme

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
fun DetailScreen(
    navHostController: NavHostController,
    singleCharacterModel: HPCharacter,
) {
    val scrollState = rememberScrollState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)),
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Transparent
                ),
                navigationIcon = {
                    NavigationButton(
                        onClick = { navHostController.popBackStack() },
                        icon = Icons.Default.ArrowBack
                    )
                },
                title = {}
            )
        }
    ) {

        Box {
            Column(
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop,
                        model = singleCharacterModel.image,
                        contentDescription = "image",
                        placeholder = painterResource(id = R.drawable.placeholder),
                        error = painterResource(id = R.drawable.placeholder)

                    )
                }
                Column {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Text(
                            text = singleCharacterModel.name,
                            style = MaterialTheme.typography.displayMedium
                        )
                        Text(
                            text = singleCharacterModel.actor,
                            style = MaterialTheme.typography.labelSmall
                        )
                        Spacer(modifier = Modifier.height(40.dp))
                        Text(
                            text = stringResource(R.string.details),
                            style = MaterialTheme.typography.displayMedium
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        DetailEntry(title = stringResource(R.string.species), value = singleCharacterModel.species)
                        DetailEntry(title = stringResource(R.string.gender), value = singleCharacterModel.gender)
                        DetailEntry(title = stringResource(R.string.house), value = singleCharacterModel.house)
                        DetailEntry(
                            title = stringResource(R.string.date_of_birth),
                            value = singleCharacterModel.dateOfBirth
                        )
                        if (singleCharacterModel.yearOfBirth > 0) {
                            DetailEntry(
                                title = stringResource(R.string.year_of_birth),
                                value = singleCharacterModel.yearOfBirth
                            )
                        }
                        DetailEntry(title = stringResource(R.string.wizard), value = singleCharacterModel.wizard)
                        DetailEntry(title = stringResource(R.string.ancestry), value = singleCharacterModel.ancestry)
                        DetailEntry(title = stringResource(R.string.eye_color), value = singleCharacterModel.eyeColor)
                        DetailEntry(title = stringResource(R.string.hair_color), value = singleCharacterModel.hairColor)
                        DetailEntry(title = stringResource(R.string.wand_wood), value = singleCharacterModel.wand.wood)
                        DetailEntry(title = stringResource(R.string.wand_core), value = singleCharacterModel.wand.core)
                        DetailEntry(title = stringResource(R.string.wand_length), value = singleCharacterModel.wand.length)
                        DetailEntry(title = stringResource(R.string.patronus), value = singleCharacterModel.patronus)
                        DetailEntry(
                            title = stringResource(R.string.hogwarts_student),
                            value = singleCharacterModel.hogwartsStudent
                        )
                        DetailEntry(
                            title = stringResource(R.string.hogwarts_staff),
                            value = singleCharacterModel.hogwartsStaff
                        )
                        if (singleCharacterModel.alternateActors.isNotEmpty()){
                            DetailEntry(
                                isList = true,
                                title = stringResource(R.string.alternative_actors),
                                list = singleCharacterModel.alternateActors
                            )
                        }
                        DetailEntry(title = stringResource(R.string.alive), value = singleCharacterModel.alive)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    PotterpedieTheme {
        DetailScreen(
            navHostController = rememberNavController(),
            singleCharacterModel = HPCharacter(
                id = "9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8",
                name = "Harry Potter",
                alternateNames = listOf("The Boy Who Lived", "The Chosen One"),
                actor = "Daniel Radcliffe",
                alternateActors = emptyList(),
                alive = true,
                ancestry = "half-blood",
                dateOfBirth = "31-07-1980",
                yearOfBirth = 1980,
                eyeColor = "green",
                gender = "male",
                hairColor = "black",
                hogwartsStaff = false,
                hogwartsStudent = true,
                house = "Gryffindor",
                image = "https://ik.imagekit.io/hpapi/harry.jpg",
                patronus = "stag",
                species = "human",
                wand = Wand("phoenix feather", 11.0, ""),
                wizard = true
            )
        )
    }
}

@Preview
@Composable
fun DetailsScreenPreviewDark() {
    PotterpedieTheme(darkTheme = true) {
        DetailScreen(
            navHostController = rememberNavController(),
            singleCharacterModel = HPCharacter(
                id = "9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8",
                name = "Harry Potter",
                alternateNames = listOf("The Boy Who Lived", "The Chosen One"),
                actor = "Daniel Radcliffe",
                alternateActors = emptyList(),
                alive = true,
                ancestry = "half-blood",
                dateOfBirth = "31-07-1980",
                yearOfBirth = 1980,
                eyeColor = "green",
                gender = "male",
                hairColor = "black",
                hogwartsStaff = false,
                hogwartsStudent = true,
                house = "Gryffindor",
                image = "https://ik.imagekit.io/hpapi/harry.jpg",
                patronus = "stag",
                species = "human",
                wand = Wand("phoenix feather", 11.0, ""),
                wizard = true
            )
        )
    }
}