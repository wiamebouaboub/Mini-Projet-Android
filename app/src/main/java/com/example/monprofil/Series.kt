package com.example.monprofil

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun Series(navController: NavController,viewModel: MainViewModel){

    val series by viewModel.series.collectAsState()
    val image = "https://image.tmdb.org/t/p/w500"

        if (series.isEmpty()) {
            viewModel.trendSeries()

        } else {
            LazyVerticalGrid(GridCells.Adaptive(120.dp)) {
                items(series) { serie ->



                    Card(onClick = { navController.navigate("serie/" + serie.id) }) {
                        AsyncImage(
                            model = image + serie.poster_path,
                            contentDescription = "poster"
                        )
                        //Text(text = serie.original_name)
                    }
                }
            }
        }
    }