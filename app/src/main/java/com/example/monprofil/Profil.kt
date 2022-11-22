package com.example.monprofil

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun Profil(windowSizeClass: WindowSizeClass, navController: NavController) {
    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(id = R.drawable.w),
                    contentDescription = "PhotoDeProfil",
                    modifier = Modifier.size(400.dp)
                )
                Text(
                    text = "Wiame Bouaboub",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    text = "Etudiante",
                    fontSize = 15.sp
                )
                Text(
                    text = "Ecole d'ingénieurs ISIS Castres - INU Champollion",
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Italic
                )
                Spacer(Modifier.height(50.dp))
                Row() {
                    Image(
                        painterResource(id = R.drawable.mail),
                        contentDescription = "PhotoDeProfil",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "wiame.bouaboub@etud.univ-jfc.fr",
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Italic
                    )
                }
                Row() {
                    Image(
                        painterResource(id = R.drawable.linkedin),
                        contentDescription = "PhotoDeProfil",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "www.linkedin.com/in/wiame.bouaboub",
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Italic
                    )
                }
                Button(onClick = { navController.navigate("Films") }) {
                    Text(text="Démarrer",color= Color.White)
                }
            }
        }
        else -> {
            Row(
                Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Image(
                        painterResource(id = R.drawable.w),
                        contentDescription = "PhotoDeProfil",
                        modifier = Modifier.size(200.dp)
                    )
                    Text(
                        text = "Wiame Bouaboub",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(20.dp))
                    Text(
                        text = "Etudiante",
                        fontSize = 15.sp
                    )
                    Text(
                        text = "Ecole d'ingénieurs ISIS Castres - INU Champollion",
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Italic
                    )
                }

                Column() {
                    Row() {
                        Image(
                            painterResource(id = R.drawable.mail),
                            contentDescription = "PhotoDeProfil",
                            modifier = Modifier.size(30.dp)
                        )
                        Text(
                            text = "wiame.bouaboub@etud.univ-jfc.fr",
                            fontSize = 12.sp,
                            fontStyle = FontStyle.Italic
                        )
                    }
                    Row() {
                        Image(
                            painterResource(id = R.drawable.linkedin),
                            contentDescription = "PhotoDeProfil",
                            modifier = Modifier.size(30.dp)
                        )
                        Text(
                            text = "www.linkedin.com/in/wiame.bouaboub",
                            fontSize = 12.sp,
                            fontStyle = FontStyle.Italic
                        )
                    }
                    Button(onClick = { navController.navigate("films") }) {
                        Text(text="Démarrer",
                        color= Color.White)
                    }
                }
            }
        }
    }
}
