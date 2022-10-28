package com.example.monprofil

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Profil(navController: NavController) {
   /* val windowClass=WindowSizeClass
    when (windowClass.javaClass) {
        WindowWidthSizeClass.Compact -> {*/
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(id = R.mipmap.w),
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
                        painterResource(id = R.mipmap.mail),
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
                        painterResource(id = R.mipmap.linkedin),
                        contentDescription = "PhotoDeProfil",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "www.linkedin.com/in/nicolas-singer",
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Italic
                    )
                }
                Button(onClick = {  navController.navigate("film")}) {
                    Text("Démarrer")
                }
            }
        }
        /*else ->{
            Row(
                Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically) {
                Column() {
                    Image(
                        painterResource(id = R.mipmap.w),
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
                            painterResource(id = R.mipmap.mail),
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
                            painterResource(id = R.mipmap.linkedin),
                            contentDescription = "PhotoDeProfil",
                            modifier = Modifier.size(30.dp)
                        )
                        Text(
                            text = "www.linkedin.com/in/nicolas-singer",
                            fontSize = 12.sp,
                            fontStyle = FontStyle.Italic
                        )
                    }
                    Button(onClick = { navController.navigate("film")}) {
                        Text("Démarrer")
                    }
                }
            }
        }

}*/
