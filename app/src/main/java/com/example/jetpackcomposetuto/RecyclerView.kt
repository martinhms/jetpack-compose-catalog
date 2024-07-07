package com.example.jetpackcomposetuto

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetuto.model.SuperHero
import kotlinx.coroutines.launch

@Composable
fun RecyclerView() {
    val myList = listOf("Martin", "Mica", "Alan", "Nicko")
    LazyColumn {
        item { Text(text = "Primer item") }
        items(count = 7) {
            Text(text = "Este es el item $it")
        }
        items(myList) {
            Text(text = "Hola! $it")
        }

    }
}

@Composable
fun SuperHeroRecyclerViewColumn() {
    val context = LocalContext.current
    Row {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeros()) { superhero ->
                ItemHero(superhero = superhero) {
                    Toast.makeText(context, superhero.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun SuperHeroRecyclerViewRow() {
    val context = LocalContext.current
    Row {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeros()) { superhero ->
                ItemHero(superhero = superhero) {
                    Toast.makeText(context, superhero.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun SuperHeroCombineRecyclerView() {
    val context = LocalContext.current
    Row {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeros()) { superhero ->
                ItemHero(superhero = superhero) {
                    Toast.makeText(context, superhero.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeros()) { superhero ->
                ItemHero(superhero = superhero) {
                    Toast.makeText(context, superhero.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun SuperHeroRecyclerSpecialControlsView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeros()) { superhero ->
                ItemHero(superhero = superhero) {
                    Toast.makeText(context, superhero.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
        val showbutton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }
        if (showbutton) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        rvState.animateScrollToItem(0)
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
            ) {
                Text(text = "Soy un boton")

            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun SuperHerGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(getSuperHeros()) { superhero ->
            ItemHero(superhero = superhero) {
                Toast.makeText(context, superhero.superheroName, Toast.LENGTH_SHORT).show()
            }
        }
    })
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroRecyclerViewSticky() {
    val context = LocalContext.current
    val superHero = getSuperHeros().groupBy { it.publisher }
    Row(Modifier.padding(top = 60.dp)) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {

            superHero.forEach { (publisher, mySuperHero) ->
                stickyHeader {
                        Text(
                            text = publisher,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White),
                            textAlign = TextAlign.Center,
                            color = Color.Black
                        )
                }
                items(mySuperHero) { superhero ->
                    ItemHero(superhero = superhero) {
                        Toast.makeText(context, superhero.superheroName, Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

    }
}


@Composable
fun ItemHero(superhero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(5.dp, Color.Red),
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .fillMaxWidth()
            .clickable { onItemSelected(superhero) }) {
        Column() {
            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = "Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superhero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superhero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
        }
        Text(
            text = superhero.publisher,
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 10.dp, bottom = 10.dp),
            fontSize = 10.sp
        )

    }
}

fun getSuperHeros(): List<SuperHero> {
    return listOf(
        SuperHero("Batman", "BruceWayne", "DC", R.drawable.batman),
        SuperHero("SpiderMan", "Peter", "Marvel", R.drawable.spiderman),
        SuperHero("DareEvil", "No me acuerdo", "Marvel", R.drawable.daredevil),
        SuperHero("Green lantern", "Alan Scoot", "DC", R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Diana", "DC", R.drawable.wonder_woman),
        SuperHero("Flash", "Jay Garric", "DC", R.drawable.flash),
        SuperHero("Thor", " Thor Odinson", "Marvel", R.drawable.thor),
        SuperHero("Wolverine", " Jame Howlett", "Marvel", R.drawable.logan),
    )
}