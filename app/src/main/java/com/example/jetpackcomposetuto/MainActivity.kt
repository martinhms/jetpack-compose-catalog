package com.example.jetpackcomposetuto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposetuto.model.Routes
import com.example.jetpackcomposetuto.navigation.Screen1
import com.example.jetpackcomposetuto.navigation.Screen2
import com.example.jetpackcomposetuto.navigation.Screen3
import com.example.jetpackcomposetuto.navigation.Screen4
import com.example.jetpackcomposetuto.navigation.Screen5
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
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Pantalla1.route
                    ) {
                        composable(Routes.Pantalla1.route) { Screen1(navigationController) }
                        composable(Routes.Pantalla2.route) { Screen2(navigationController) }
                        composable(Routes.Pantalla3.route) { Screen3(navigationController) }
                        composable(
                            Routes.Pantalla4.route,
                            arguments = listOf(navArgument("age") { type = NavType.IntType })
                        ) { backStackEntry ->
                            Screen4(
                                navigationController = navigationController,
                                age = backStackEntry.arguments?.getInt("age") ?: 0
                            )
                        }
                        composable(
                            Routes.Pantalla5.route,
                            arguments = listOf(navArgument("name"
                            ) { defaultValue = "default Value" })
                        ) { backStackEntry ->
                            Screen5(
                                navigationController = navigationController,
                                name = backStackEntry.arguments?.getString("name")
                            )
                        }

                    }

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
                    //SuperHeroRecyclerViewSticky()
                    //ScaffoldExample()
                    //DrawerMenu()

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