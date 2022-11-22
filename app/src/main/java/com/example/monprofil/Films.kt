package com.example.monprofil

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

@Composable
@OptIn( ExperimentalMaterialApi::class)
fun Films(navController: NavController,viewModel: MainViewModel){

    val movies by viewModel.movies.collectAsState()
    val image = "https://image.tmdb.org/t/p/w500"

        if (movies.isEmpty()) {
            viewModel.trendMovies()
        } else {
            LazyVerticalGrid(GridCells.Adaptive(120.dp)) {
                items(movies) { movie ->
                    Card(onClick = { navController.navigate("film/"+ movie.id) }) {
                    AsyncImage(
                        model = image + movie.poster_path,
                        contentDescription = "poster",
                    )
                    }
                }
            }
        }}



