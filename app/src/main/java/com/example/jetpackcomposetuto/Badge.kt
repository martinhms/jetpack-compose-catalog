package com.example.jetpackcomposetuto

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BadgeBox() {
    val badge = Badge(Modifier.padding(16.dp), content = {
        Text(text = "1")
        Icon(imageVector = Icons.Default.Star, contentDescription = "")
    })
    /*    BadgedBox(badge = {
            Icon(imageVector = Icons.Default.Star, contentDescription = "")
        },
            modifier = Modifier.padding(16.dp),
            content = { Text(text = "1")})*/
}