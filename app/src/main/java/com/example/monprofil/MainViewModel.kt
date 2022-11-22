package com.example.monprofil

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {

    val movies = MutableStateFlow<List<Movie>>(listOf())
    val movie= MutableStateFlow<MovieInfo?>(null)
    val series = MutableStateFlow<List<Serie>>(listOf())
    val serie= MutableStateFlow<SerieInfo?>(null)
    val people = MutableStateFlow<List<People>>(listOf())
    val apikey = "15e271675480de8e647ccb9b8d5593b5"
    val service = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(TmdbAPI::class.java)

    fun searchMovies(motcle: String) {
        viewModelScope.launch {
            movies.value = service.getFilmsParMotCle(apikey, motcle).results
        }
    }
        fun trendMovies() {
            viewModelScope.launch {
                movies.value = service.getFilmsInitiaux(apikey).results
            }
        }

    fun trendSeries() {
        viewModelScope.launch {
            series.value = service.getSeriesInitiaux(apikey).results
        }
    }

    fun trendPeople() {
        viewModelScope.launch {
            people.value = service.getActeurs(apikey).results
        }
    }

    fun infoMovie(id:String) {
        viewModelScope.launch {
            movie.value= service.getFilm(id,apikey, "credits")
        }
    }

    fun infoSerie(id:String) {
        viewModelScope.launch {
            serie.value= service.getSerie(id,apikey, "credits")
        }
    }

}
