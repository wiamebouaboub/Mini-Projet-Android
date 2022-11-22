package com.example.monprofil

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun Film(viewModel: MainViewModel, id: String) {

    val movie by viewModel.movie.collectAsState()
    val image = "https://image.tmdb.org/t/p/w500"

    if (id != null) {
        viewModel.infoMovie(id);

        if (movie == null) {
            Text("Il y a une erreur, veuillez quitter la page.")
        } else {
            Column() {
                Text(text = movie!!.original_title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                )
                Spacer(Modifier.height(20.dp))

                AsyncImage(
                    model = image + movie!!.poster_path,
                    contentDescription = "poster",
                )
                Spacer(Modifier.height(20.dp))

                Text( "Sortie le " + movie!!.release_date + "/" + "Genre: " + movie!!.genres)

                Spacer(Modifier.height(20.dp))

                Text(text="Synopsis:",
                fontWeight = FontWeight.Bold,
                )
                Text(movie!!.overview)
                Spacer(Modifier.height(20.dp))

                Text(text="Distribution:",
                    fontWeight = FontWeight.Bold,
                )

                if (movie!!.credits.cast.isEmpty()) {
                    Text("Il n'y a pas d'acteurs référencés pour ce film.")
                } else {
                    LazyVerticalGrid(GridCells.Adaptive(120.dp)) {
                        items(movie!!.credits.cast) { cast ->
                            Card() {
                                Column() {


                                    AsyncImage(
                                        model = image + cast.profile_path,
                                        contentDescription = "cast",
                                    )
                                    Spacer(Modifier.height(20.dp))
                                    Text(cast.original_name)
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}



