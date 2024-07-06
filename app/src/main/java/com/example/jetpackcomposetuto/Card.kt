package com.example.jetpackcomposetuto

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Card() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),// Ajusta el valor de elevación según tus necesidades,
        shape = MaterialTheme.shapes.large,
        colors = CardColors(
            contentColor = Color.White,
            containerColor = Color.DarkGray,
            disabledContentColor = Color.Blue,
            disabledContainerColor = Color.White
        ),
        border = BorderStroke(5.dp, Color.Blue)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")
        }

    }
}