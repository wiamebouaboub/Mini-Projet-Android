package com.example.monprofil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Slideshow
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.monprofil.ui.theme.MonProfilTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MonProfilTheme {
                // A surface container using the 'background' color from the theme
                val windowSizeClass = calculateWindowSizeClass(this)
                val navController = rememberNavController()
                val viewModel : MainViewModel by viewModels()

                    NavHost(
                        navController = navController,
                        startDestination = "profil") {
                        composable("profil") {
                            Profil(windowSizeClass,navController)
                        }
                        composable("films") {
                            NavigationLayout(navController,viewModel){Films(navController,viewModel)};
                        }
                        composable("Series") {
                            NavigationLayout(navController,viewModel){Series(navController, viewModel)};
                        }
                        composable("Personnes") {
                            NavigationLayout(navController,viewModel){Personnes(navController, viewModel)};
                        }
                        composable("film/"+"{id}") {NavBackStack ->
                            NavBackStack.arguments?.getString("id")
                                ?.let { Film(viewModel, id= it) };
                        }
                        composable("serie/"+"{id}") {NavBackStack ->
                            NavBackStack.arguments?.getString("id")
                                ?.let { Serie(viewModel, id= it) };
                        }
                    }

                }
            }
        }
    }

@Composable
fun NavigationLayout(navController : NavController, viewModel: MainViewModel, content: @Composable() () -> Unit){
    Surface(color = MaterialTheme.colors.background) {
        var motcle by remember { mutableStateOf("") }
        Scaffold(
            topBar={
            TopAppBar(
                title = { Text(text = "Recherche") },
                actions = {
                    TextField(
                        value = motcle,
                        onValueChange = {
                            motcle=it
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = {viewModel.searchMovies(motcle); }),
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                tint = Color.White,
                                contentDescription = "loupe"
                            )
                        },
                    )
                })},
                bottomBar = {
                    BottomNavigation {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination

                        BottomNavigationItem(
                            icon = { Icon(Icons.Filled.Movie, contentDescription = null) },
                            label = { Text("Films") },
                            selected = currentDestination?.hierarchy?.any { it.route == "Films" } == true,
                            onClick = {
                                navController.navigate("Films")
                            }
                        )
                        BottomNavigationItem(
                            icon = { Icon(Icons.Filled.Slideshow, contentDescription = null) },
                            label = { Text("Series") },
                            selected = currentDestination?.hierarchy?.any { it.route == "series" } == true,
                            onClick = { navController.navigate("series")}
                        )
                        BottomNavigationItem(
                            icon = { Icon(Icons.Filled.Person, contentDescription = null) },
                            label = { Text("Personnes") },
                            selected = currentDestination?.hierarchy?.any { it.route == "Personnes" } == true,
                            onClick = {navController.navigate("Personnes")}
                        )
                    }
                }

        ) {
            content()
        }
    }
}




