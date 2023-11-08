package com.iessanalberto.dam2.mixjuegos

import android.app.AlertDialog
import android.widget.EditText
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimeraScreen (navController: NavController) {

    var marcador by rememberSaveable { mutableStateOf(0) }
    var opcionPoN = remember { mutableStateOf(TextFieldValue()) }
    var tirada = remember {mutableStateOf(TextFieldValue())}
    var context = LocalContext.current
    val alert = AlertDialog.Builder(context)
    Scaffold(//App bars en android, hay un diccionario de topbars para mirar
        topBar = {
            CenterAlignedTopAppBar( //para añadir la variable dentro del string
                title = {
                    Text(
                        text = "Marcador: $marcador",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    //material Theme en google y te salen, color del contenedor
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(route = AppScreen.MenuScreen.route) }) {
                        //arrowBack es la flecha de volver atrás, hay muchos más
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Atrás")
                    }
                }
            )
        } //cierra topBar
    )//cierra Scaffold
    { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                //hay que añadir el padding con el innerPadding para que no falle
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(20.dp),//spacedBy(20.dp),//para espaciar con medida
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = "Juego de Pares o Nones",
                modifier = Modifier.padding(15.dp, 40.dp, 15.dp,30.dp),
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Elige: Pares o Nones",
                modifier = Modifier.padding(20.dp),
                textAlign = TextAlign.Left,
                fontSize = 20.sp,
                //fontWeight = FontWeight.Bold
            )
            TextField(
                value = opcionPoN.value,
                onValueChange = { opcionPoN.value = it },
                placeholder = { Text(text = "Opción") },
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "Elige la tirada de (0-3)",
                modifier = Modifier.padding(20.dp),
                textAlign = TextAlign.Left,
                fontSize = 20.sp,
                //fontWeight = FontWeight.Bold
            )
            TextField(
                value = tirada.value,
                onValueChange = { tirada.value = it },
                placeholder = { Text(text = "Tirada") },
                modifier = Modifier.padding(20.dp)
            )
            Button(onClick = {
                var tiradaMaquina = (0..3).random()
                //como es un textFiel para poder extraer el valor y pasarlo a int
                val resultado = tirada.value.text.toInt() + tiradaMaquina
                var pares = resultado % 2 == 0
                if (pares) {
                    alert.setMessage(
                        "Player: ${tirada.value.text.toInt()}" + "\n" +
                                "Machine: $tiradaMaquina" + "\n" + "Resultado: $resultado" + "\n" +
                                "Ganan los Pares "
                    )
                    alert.show()
                    if (opcionPoN.value.text.toString() == "pares") {
                        Toast.makeText(context, "Enhorabuena has acertado", Toast.LENGTH_SHORT)
                            .show()
                        marcador += 10

                    } else {
                        Toast.makeText(context, "Has perdido", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    alert.setMessage(
                        "Player: ${tirada.value.text.toInt()}" + "\n" +
                                "Machine: $tiradaMaquina" + "\n" + "Resultado: $resultado" + "\n" +
                                "Ganan los Nones"
                    )
                    alert.show()
                    if (opcionPoN.value.text.toString() == "nones") {
                        Toast.makeText(context, "Enhorabuena has acertado", Toast.LENGTH_SHORT)
                            .show()
                        marcador += 10
                    }else {
                        Toast.makeText(context, "Has perdido", Toast.LENGTH_SHORT).show()
                    }
                }
            }) {
                Text(text = "Jugar")

            }

        }
    }
}