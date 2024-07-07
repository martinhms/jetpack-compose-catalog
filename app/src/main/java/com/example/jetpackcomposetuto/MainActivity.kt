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
                    /*
             ***UNCOMMENT THE COMPOSABLE FUNCTION TO RENDER IN APP ***
                                      * */
                    //DropDownMenu()
                    //Card()
                    //BasicSlider()
                    //AdvanceSlider()
                    //MyRangeSlider()
                    //MyRadioButtonList(selected) { selected = it }
                    //MyCard()
                    //MyBadgeBox()
                    //MyDropDownMenu()
                    //ShowDialogs()
                    //RecyclerView()
                    //SuperHeroRecyclerViewColumn()
                    //SuperHeroRecyclerViewRow()
                    //SuperHeroCombineRecyclerView()
                    //SuperHeroRecyclerSpecialControlsView()
                    //SuperHerGridView()
                    SuperHeroRecyclerViewSticky()
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
/*        DropDownMenu()
        Card()
        BasicSlider()
        AdvanceSlider()*/
        MyRangeSlider()
    }

}