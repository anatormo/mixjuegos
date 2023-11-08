package com.iessanalberto.dam2.mixjuegos

import android.view.Menu
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MenuScreen (navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,//spacedBy(20.dp),//para espaciar con medida
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Menú de Juegos",
            modifier = Modifier.padding(30.dp, 1.dp, 1.dp, 20.dp),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Column {

            Image(
                painter = painterResource(id = R.drawable.piedrapapel),
                contentDescription = "ParesNones",
                contentScale = ContentScale.Inside, modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    //.padding(4.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
            Text(
                text = "Pares o nones",
                // modifier = Modifier.padding(30.dp, 1.dp, 1.dp, 20.dp),
                textAlign = TextAlign.Center,
                fontSize = 12.sp
            )

            Button(onClick = { navController.navigate(route = AppScreen.PrimeraScreen.route )}) {
                Text(text = "Jugar")

            }

        }

        Column {

            Image(
                painter = painterResource(id = R.drawable.piedrapapel),
                contentDescription = "Piedra, papel o tijeras",
                contentScale = ContentScale.Inside, modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    //.padding(4.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
            Text(
                text = "Piedra, papel o tijeras",
                // modifier = Modifier.padding(30.dp, 1.dp, 1.dp, 20.dp),
                textAlign = TextAlign.Center,
                fontSize = 12.sp
            )

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Jugar")

            }

        }

    }


}

