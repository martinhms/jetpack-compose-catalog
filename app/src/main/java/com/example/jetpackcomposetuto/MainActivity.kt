package com.example.jetpackcomposetuto

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.RadioButton
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetuto.ui.theme.JetpackComposeTutoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTutoTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    var show by remember {
                        mutableStateOf(false)
                    }
                    var showMySimpleCustomDialog by remember {
                        mutableStateOf(false)
                    }
                    var showMyCustomDialog by remember {
                        mutableStateOf(false)
                    }
                    var showMyConfirmationDialog by remember {
                        mutableStateOf(false)
                    }
                    Column(Modifier.padding(30.dp)) {
                        BasicSlider()
                        AdvanceSlider()
                        MyRangeSlider()


                        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                            Button(onClick = {
                                show = true
                                showMySimpleCustomDialog = true
                                showMyCustomDialog = true
                                showMyConfirmationDialog = true
                            }) {
                                Text(text = "Mostrar dialogs")
                            }
                            MyDialog(
                                show = show,
                                onDismiss = { show = false },
                                onConfirm = { Log.i("martin", "click") })

                            MySimpleCustomDialog(showMySimpleCustomDialog, onDismiss = { showMySimpleCustomDialog = false })
                            MyCustomDialog(showMyCustomDialog, onDismiss = { showMyCustomDialog = false })
                            MyConfirmationDialog(showMyConfirmationDialog, onDismiss = { showMyConfirmationDialog = false })
                        }
                        //MyRadioButtonList(selected) { selected = it }
                        //  MyCard()
                        //MyBadgeBox()
                        //MyDropDownMenu()
                    }
                }
            }

        }
        //var myText by remember { mutableStateOf("Martin") }
        //MyRadioButtonList()
        // MyText(myText) { myText = it }
    }
}


@Composable
fun MyDropDownMenu() {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val desertss = listOf("Helado", "Torta", "Cafe", "Fruta")

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable {}
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desertss.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        selectedText = option
                        expanded = true
                        Log.d("Dropdown", "Expanded: $expanded")
                    },
                    text = { Text(text = option) } // Corrección: usar el parámetro 'text'
                )
            }
        }
    }
}

@Composable
fun MyBadgeBox() {
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


@Composable
fun MyCard() {
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

@Composable
fun MyText(name: String, onValueChange: (String) -> Unit) {
    Row(Modifier.fillMaxWidth()) {
        var myText by remember { mutableStateOf("Martin") }
        TextField(value = "Hello $name!", onValueChange = { onValueChange(it) })
    }
}




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Column {
        BasicSlider()
        AdvanceSlider()
        MyRangeSlider()
    }

}