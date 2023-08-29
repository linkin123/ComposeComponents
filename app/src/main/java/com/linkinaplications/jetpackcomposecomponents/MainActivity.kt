package com.linkinaplications.jetpackcomposecomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.linkinaplications.jetpackcomposecomponents.ui.theme.JetpackComposeComponentsTheme
import com.linkinaplications.jetpackcomposecomponents.ui.theme.Routes
import com.linkinaplications.jetpackcomposecomponents.ui.theme.Screen1
import com.linkinaplications.jetpackcomposecomponents.ui.theme.Screen2
import com.linkinaplications.jetpackcomposecomponents.ui.theme.Screen3
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeComponentsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    //ScaffoldExample()
                    val navigationController = rememberNavController()
                    NavHost(navController = navigationController, startDestination = Routes.Pantalla1.route){
                        composable(Routes.Pantalla1.route){
                            Screen1(navigationController)
                        }
                        composable(Routes.Pantalla2.route){
                            Screen2(navigationController)
                        }
                        composable(Routes.Pantalla3.route){
                            Screen3(navigationController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopAppBar {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        "has puldado $it"
                    )
                }
            }
        }, scaffoldState = scaffoldState,
        bottomBar = { MyBottomNavigation()}
    ) {

    }
}

@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit) {
    TopAppBar(
        title = { Text(text = "Mi primera toolbar", color = Color.White) },
        backgroundColor = Color.Red,
        navigationIcon = {
            IconButton(onClick = { onClickIcon("Atrás") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search")
            }
            IconButton(onClick = { onClickIcon("Exit") }) {
                Icon(imageVector = Icons.Filled.ExitToApp, contentDescription = "exist")
            }
        }
    )
}


@Composable
fun MyBottomNavigation() {
    var index by remember {
        mutableStateOf(0)
    }
    BottomNavigation(backgroundColor = Color.Red, contentColor = Color.White) {
        BottomNavigationItem(selected = index== 0, onClick = { index=0 }, icon = {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Fav")
        }, label = { Text(text = "Fav") })

        BottomNavigationItem(selected = index==1, onClick = {index = 1 }, icon = {
            Icon(imageVector = Icons.Filled.Home, contentDescription = "Home")
        }, label = { Text(text = "Home") })

        BottomNavigationItem(selected = index==2, onClick = {index=2 }, icon = {
            Icon(imageVector = Icons.Filled.Person, contentDescription = "Person")
        }, label = { Text(text = "Person") })
    }
}























