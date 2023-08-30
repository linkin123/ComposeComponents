package com.linkinaplications.jetpackcomposecomponents.ui.theme

sealed class Routes(val route: String){
    object Pantalla1: Routes("pantalla1")
    object Pantalla2: Routes("pantalla2")
    object Pantalla3: Routes("pantalla3")
    object Pantalla4: Routes("pantalla4/{age}"){
        fun createRoute(age : Int) = "pantalla4/$age"
    }
}
