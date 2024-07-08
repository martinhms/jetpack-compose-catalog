package com.example.jetpackcomposetuto

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = { MyTopAppBar(snackbarHostState, coroutineScope) },
        content = { padding ->
            // Aquí va el contenido principal de tu pantalla
            // Usa el padding para evitar que el contenido se superponga con la TopAppBar
            Column(modifier = Modifier.padding(padding)) {
                Text(text = "Hola desde el contenido de la pantalla")
                // Agrega más elementos aquí...
            }
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        bottomBar = { MybuttonNavigation()}

    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(snackbarHostState: SnackbarHostState, scope: CoroutineScope) {
    TopAppBar(
        title = { Text(text = "Tool Bar") },
        colors = TopAppBarColors(
            containerColor = Color.LightGray,
            scrolledContainerColor = Color.White,
            navigationIconContentColor = Color.Blue,
            actionIconContentColor = Color.Green,
            titleContentColor = Color.White,
        ),
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(message = "Back")
                }
            }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(message = "Search")
                }
            }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(message = "Favorite")
                }
            }) {
                Icon(imageVector = Icons.Filled.Star, contentDescription = "Favorite")
            }
            IconButton(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(message = "Account")
                }
            }) {
                Icon(imageVector = Icons.Filled.AccountBox, contentDescription = "Account")
            }

        }
    )
}

@Composable
fun MybuttonNavigation() {
    BottomNavigation {
        BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(imageVector = Icons.Default.Home, contentDescription = "home")
        }, label = { Text(text = "Home") })


        BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
        }, label = { Text(text = "Favorite") })

        BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Person")
        }, label = { Text(text = "Person") })
    }
}