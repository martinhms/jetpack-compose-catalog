package com.example.jetpackcomposetuto.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.jetpackcomposetuto.model.Routes

@Composable
fun Screen1(navigationController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Cyan))
    {
        Button(onClick = {
            navigationController.navigate(Routes.Pantalla2.route)
        }, modifier = Modifier.align(Alignment.Center)) {
            Text(text = "Navigate to 2")
        }    }
}

@Composable
fun Screen2(navigationController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Gray))
    {
        Button(onClick = {
            navigationController.navigate(Routes.Pantalla3.route)
        }, modifier = Modifier.align(Alignment.Center)) {
            Text(text = "Navigate to 3")
        }
    }
}

@Composable
fun Screen3(navigationController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Red))
    {
        Button(onClick = {
            navigationController.navigate(Routes.Pantalla4.createRoute(32))
        }, modifier = Modifier.align(Alignment.Center)) {
            Text(text = "Navigate to 4")
        }    }
}

@Composable
fun Screen4(navigationController: NavHostController, age: Int) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Red))
    {
        Button(onClick = {
            navigationController.navigate(Routes.Pantalla5.createRoute("Martin"))
           // navigationController.navigate(Routes.Pantalla5.route) if empty defaoult value
        }, modifier = Modifier.align(Alignment.Center)) {
            Text(text = "I am $age years old")
        }    }
}


@Composable
fun Screen5(navigationController: NavHostController, name: String?) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Blue))
    {
        Button(onClick = {
            navigationController.navigate(Routes.Pantalla1.route)
        }, modifier = Modifier.align(Alignment.Center)) {
            Text(text = "My name is $name ")
        }    }
}