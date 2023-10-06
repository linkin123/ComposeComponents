package com.linkinaplications.jetpackcomposecomponents.ui.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.linkinaplications.jetpackcomposecomponents.ui.theme.ComponentType.*
import kotlin.random.Random.Default.nextInt



@Composable
fun ColorAnimationSimple() {

    Column {
        var firstColor by rememberSaveable {
            mutableStateOf(false)
        }

        val realColor = if (firstColor) Color.Red else Color.Yellow

        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable { firstColor = !firstColor })

        Spacer(modifier = Modifier.size(200.dp))


        var secondColor by rememberSaveable {
            mutableStateOf(false)
        }

        var showBox by rememberSaveable {
            mutableStateOf(true)
        }

        val realColor2 by animateColorAsState(
            targetValue = if (secondColor) Color.Red else Color.Yellow,
            animationSpec = tween(2000),
            finishedListener = { showBox = false },
            label = "realColor"
        )

        if (showBox) {
            Box(modifier = Modifier
                .size(100.dp)
                .background(realColor2)
                .clickable { secondColor = !secondColor })
        }
    }
}

@Composable
fun SizeAnimation() {
    var smallSize by rememberSaveable {
        mutableStateOf(true)
    }

    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 100.dp,
        animationSpec = tween(500),
        label = "animation size",
        finishedListener = {
            if (!smallSize) {
            }
        }
    )

    Box(modifier = Modifier
        .size(size)
        .background(Color.Cyan)
        .clickable { smallSize = !smallSize })
}

@Composable
fun VisibilityAnimation() {
    var isVisible by remember { mutableStateOf(true) }

    Column(Modifier.fillMaxSize()) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Mostrar / Ocultar")
        }

        Spacer(modifier = Modifier.size(50.dp))

        AnimatedVisibility(
            isVisible,
            enter = fadeIn() + slideInHorizontally(),
            exit = fadeOut() + slideOutHorizontally(),
            label = ""
        ) {
            Box(
                Modifier
                    .size(150.dp)
                    .background(Color.Red)
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun VisibilityEnterAnimation() {
    var isVisible by remember { mutableStateOf(true) }

    Column(Modifier.fillMaxSize()) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Mostrar / Ocultar")
        }

        Spacer(modifier = Modifier.size(50.dp))

        AnimatedVisibility(
            isVisible,
            enter = fadeIn(),
            exit = fadeOut(),
            label = ""
        ) {
            Box(
                Modifier
                    .size(150.dp)
                    .background(Color.Red)
                    .animateEnterExit(
                        enter = expandVertically(),
                        exit = shrinkHorizontally(),
                        label = ""
                    )
            )
        }
    }
}

@Composable
fun CrossFadeExampleAnimation() {
    var myComponentType : ComponentType by remember {
        mutableStateOf(Text)
    }

    Column(Modifier.fillMaxSize()) {
        Button(onClick = { myComponentType = getComponentRandom() }) {
            Text(text = "Cambiar componente")
        }

        Crossfade(targetState = myComponentType, label = "") { myComponentType ->
            when (myComponentType) {
                Image -> Icon(Icons.Default.Send, contentDescription = "")
                Text -> Text(text = "soy un componente")
                Box -> Box(
                    Modifier
                        .size(150.dp)
                        .background(Color.Red)
                )
                Error -> Text(text= "ERORR")
            }
        }
    }
}

fun getComponentRandom(): ComponentType {
    return when (nextInt(from = 0, until = 3)) {
        0 -> Image
        1 -> Text
        2 -> Box
        else -> Error
    }
}

enum class ComponentType {
    Image, Text, Box, Error
}

