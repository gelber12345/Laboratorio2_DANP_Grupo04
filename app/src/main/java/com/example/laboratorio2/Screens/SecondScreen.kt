package com.example.laboratorio2.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp

@Composable
fun SecondScreen(navController: NavController, text :String?){
    Scaffold(
        topBar = {
            TopAppBar() {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back",
                    modifier = Modifier.clickable{
                        navController.popBackStack()
                    })
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "PLATOS TIPICOS")
            }
        }
    ) {
        BodySecond(navController, text)
    }
}

@Composable
fun BodySecond(navController: NavController, text :String?){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("SEGUNDA PANTALLA")
        //SI existe el parametro se imprime
        text?.let {
            Text(it)
        }
        Button(
            onClick = {navController.popBackStack()}
        ){
            Text("CONSULTAR")
        }
    }
}