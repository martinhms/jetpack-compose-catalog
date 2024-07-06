package com.example.jetpackcomposetuto

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
                        DropDownMenu()
                        Card()
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

                            MySimpleCustomDialog(
                                showMySimpleCustomDialog,
                                onDismiss = { showMySimpleCustomDialog = false })
                            MyCustomDialog(
                                showMyCustomDialog,
                                onDismiss = { showMyCustomDialog = false })
                            MyConfirmationDialog(
                                showMyConfirmationDialog,
                                onDismiss = { showMyConfirmationDialog = false })
                        }
                        //MyRadioButtonList(selected) { selected = it }
                        //  MyCard()
                        //MyBadgeBox()
                        //MyDropDownMenu()
                        //RecyclerView()
                        // SuperHeroRecyclerView()
                        SuperHerGridView()
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
fun MyText(name: String, onValueChange: (String) -> Unit) {
    Row(Modifier.fillMaxWidth()) {
        var myText by remember { mutableStateOf("Martin") }
        TextField(value = "Hello $name!", onValueChange = { onValueChange(it) })
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Column {
        DropDownMenu()
        Card()
        BasicSlider()
        AdvanceSlider()
        MyRangeSlider()
    }

}