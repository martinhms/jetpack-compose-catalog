package com.example.jetpackcomposetuto

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

    Column(Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Ejemplo 1", onClick = { onItemSelected("Ejemplo 1") })
            Text(text = "Ejemplo 1")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Ejemplo 2", onClick = { onItemSelected("Ejemplo 2") })
            Text(text = "Ejemplo 2")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Ejemplo 3", onClick = { onItemSelected("Ejemplo 3") })
            Text(text = "Ejemplo 3")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Ejemplo 4", onClick = { onItemSelected("Ejemplo 4") })
            Text(text = "Ejemplo 4")
        }
    }
}