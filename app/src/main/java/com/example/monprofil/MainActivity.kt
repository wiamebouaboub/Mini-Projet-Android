package com.example.monprofil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.monprofil.ui.theme.MonProfilTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MonProfilTheme {
                // A surface container using the 'background' color from the theme
                @Composable
                fun Screen() {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "profil") {
                        composable("profil") {
                            Profil(navController)
                        }
                        composable("film") {
                            Film(navController)
                        }
                    }
                }
                val windowSizeClass = calculateWindowSizeClass(this)
                    Profile(windowSizeClass)

                }
            }
        }
    }

@Composable
fun Profile(windowClass: WindowSizeClass) {
    when (windowClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
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
                Button(onClick = {  /*navController.navigate("film")*/ }) {
                    Text("Démarrer")
                }
            }
        }
        else ->{
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
                    Button(onClick = { /* Do something! */ }) {
                        Text("Démarrer")
                    }
                }
            }
        }
    }
}





@Preview(showBackground=true)
@Composable
fun DefaultPreview() {


}
