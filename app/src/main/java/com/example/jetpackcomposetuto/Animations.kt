package com.example.jetpackcomposetuto

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt


@Composable
fun ShowAnimationsCatalog() {
    val modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight()
        .background(Color.Gray)
    Column(modifier) {
        ColorAnimationSimple(modifier)
        Spacer(modifier = Modifier.padding(10.dp))
        SizeAnimation(modifier)
        Spacer(modifier = Modifier.padding(10.dp))
        VisibilityAnimation()
        Spacer(modifier = Modifier.padding(10.dp))
        CrossfadeAnimation()
    }

}

@Composable
fun ColorAnimationSimple(modifier: Modifier) {
    var firstColor by rememberSaveable { mutableStateOf(false) }
    val realColor = if (firstColor) Color.Red else Color.Blue

    Column(
        Modifier
            .wrapContentHeight()
            .background(Color.Gray)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor)
                .clickable { firstColor = !firstColor })

        Spacer(modifier = Modifier.padding(10.dp))

        var secondColor by rememberSaveable { mutableStateOf(false) }

        val realColor2 by animateColorAsState(
            targetValue = if (secondColor) Color.Red else Color.Blue,
            label = "",
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor2)
                .clickable { secondColor = !secondColor })

        Spacer(modifier = Modifier.padding(10.dp))

        var color3 by rememberSaveable { mutableStateOf(false) }
        var showBox by rememberSaveable { mutableStateOf(true) }
        val realColor3 by animateColorAsState(
            targetValue = if (color3) Color.Red else Color.Blue,
            label = "",
            animationSpec = tween(durationMillis = 3000),
            finishedListener = { showBox = !showBox }
        )
        Row {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(realColor3)
                    .clickable { color3 = !color3 })


            Spacer(modifier = Modifier.padding(5.dp))

            if (showBox) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Button")
                }
            }
        }
    }
}


@Composable
fun SizeAnimation(modifier: Modifier) {
    var smallSize by rememberSaveable { mutableStateOf(true) }
    var changeColor by rememberSaveable { mutableStateOf(true) }

    val size by animateDpAsState(
        targetValue = if (smallSize) 100.dp else 200.dp,
        animationSpec = tween(durationMillis = 4000),
        label = "",
        finishedListener = { changeColor = !changeColor }
    )

    Column {
        Box(
            modifier = Modifier
                .size(size)
                .padding(10.dp)
                .background(Color.Green)
                .clickable { smallSize = !smallSize }) {

            Text(
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.Center),
                text = "I change color when animation finish",
                color = if (changeColor) Color.Black else Color.Magenta
            )
        }
    }

}


@Composable
fun VisibilityAnimation() {
    var isVisible by rememberSaveable {
        mutableStateOf(true)
    }
    Column() {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Show/Hide")
        }
        Spacer(modifier = Modifier.size(10.dp))

        AnimatedVisibility(isVisible, enter = slideInHorizontally()) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Red)
            )
        }
    }

}


@Composable
fun CrossfadeAnimation() {
    var myComponentType: ComponentType by remember {
        mutableStateOf(ComponentType.Text)
    }

    Column(Modifier.wrapContentHeight()) {
        Button(onClick = { myComponentType = getRandomComponent() }) {
            Text(text = "Change component")
        }

        Crossfade(
            targetState = myComponentType, animationSpec = tween(2000),
            label = ""
        ) { myComponentType ->
            when (myComponentType) {
                ComponentType.Image -> Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = ""
                )

                ComponentType.Text -> Text(text = "i am a Text component")
                ComponentType.Box -> Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Cyan)
                )

                ComponentType.Error -> Text(text = "i am a Error")
            }
        }

    }

}

fun getRandomComponent(): ComponentType {
    return when (nextInt(from = 0, until = 3)) {
        0 -> ComponentType.Image
        1 -> ComponentType.Text
        2 -> ComponentType.Box
        else -> ComponentType.Error
    }
}


enum class ComponentType {
    Image, Text, Box, Error
}


