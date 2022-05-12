package com.example.laboratorio2.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import android.os.Bundle
import com.example.laboratorio2.R

private val arequipa: List<MyDish> = listOf(
    MyDish("Rocoto Relleno"),
    MyDish("Americano"),
    MyDish("Adobo"),
    MyDish("Chicharon"))
private val lima: List<MyDish> = listOf(
    MyDish("Ceviche"),
    MyDish("Ají de gallina"),
    MyDish("Papas a la huancaína"),
    MyDish("Suspiro a la limeña"))
private val cusco: List<MyDish> = listOf(
    MyDish("Chiri Uchu"),
    MyDish("Trucha Frita"),
    MyDish("Chairo"),
    MyDish("Sopa de Quinua"))


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
        Text("PLATOS TIPICOS DE")
        //Si existe el parametro se imprime
        text?.let {
            Text(it)
        }
        when (text) {
            "CUSCO" -> {
                MyList(cusco)
            }
            "AREQUIPA" -> {
                MyList(arequipa)
            }
            "LIMA" -> {
                MyList(lima)
            }
        }


        Button(
            onClick = {navController.popBackStack()}
        ){
            Text("VOLVER A CONSULTAR")
        }
    }
}

data class MyDish(val name:String)

@Composable
fun MyList(platos: List<MyDish>){
    LazyColumn {
        items(platos) { dish->
            MyComponent(dish)
        }
    }
}

@Composable
fun MyComponent(dish:MyDish){
    Row(modifier = Modifier.padding(8.dp)) {
        MyTexts(dish)
    }
}

@Composable
fun MyTexts(dish:MyDish){
    Column(modifier = Modifier.padding(start=8.dp)) {
        MyText(dish.name)
    }
}

@Composable
fun MyText(text: String){
    Row {
        Image(painterResource(id = R.drawable.ic_launcher_foreground),"Imagen prueba")
        Text(text)
    }
}

/*@Preview(showSystemUi = true)
@Composable
fun PreviewComponent(){
   val scrollState= rememberScrollState()
   Column(modifier = Modifier.verticalScroll(scrollState)) {
       MyList(arequipa)
   }
}*/
