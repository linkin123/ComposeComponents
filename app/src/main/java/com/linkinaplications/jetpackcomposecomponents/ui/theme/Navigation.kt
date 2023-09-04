package com.linkinaplications.jetpackcomposecomponents.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun Screen1(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(
            text = "pantalla 1",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Routes.Pantalla2.route) })
    }
}

@Composable
fun Screen2(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(
            text = "pantalla 2",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Routes.Pantalla3.route) })
    }
}

@Composable
fun Screen3(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = "pantalla 3",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Routes.Pantalla4.createRoute(31)) })
    }
}

@Composable
fun Screen4(navController: NavHostController, age: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(
            text = "tengo $age años",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Routes.Pantalla5.createRoute("Linkin")) })
//                .clickable { navController.navigate("pantalla5") })
    }
}

@Composable
fun Screen5(navController: NavHostController, name: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(text = "Me llamo $name", modifier = Modifier.align(Alignment.Center))
    }
}