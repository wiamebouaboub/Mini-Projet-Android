package com.example.monprofil

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun Personnes(navController: NavController, viewModel: MainViewModel){
    val people by viewModel.people.collectAsState()
    val image = "https://image.tmdb.org/t/p/w500"

    if (people.isEmpty()) {
        viewModel.trendPeople()
    } else {
        LazyVerticalGrid(GridCells.Adaptive(120.dp)) {
            items(people) { person ->
                Card() {
                    Column() {
                        AsyncImage(
                            model = image + person.profile_path,
                            contentDescription = "poster",
                        )
                        Spacer(Modifier.height(10.dp))
                        Text(text = person.original_name)
                    }

                }
            }
        }
    }
}