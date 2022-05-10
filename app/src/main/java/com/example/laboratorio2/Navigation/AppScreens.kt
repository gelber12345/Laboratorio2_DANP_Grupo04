package com.example.laboratorio2.Navigation

sealed class AppScreens(val route : String){
    object FirstSreen : AppScreens ("first_screen")
    object SeconSreen : AppScreens ("secon_screen")
}
