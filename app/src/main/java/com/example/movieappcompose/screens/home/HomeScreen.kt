package com.example.movieappcompose.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappcompose.model.Movie
import com.example.movieappcompose.model.getMovies
import com.example.movieappcompose.navigation.MovieScreens
import com.example.movieappcompose.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black),
            title = { Text(text = "Movies", color = Color.White) }
        )

    }) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues),
            color = MaterialTheme.colorScheme.background
        ) {
            MainContent(navController = navController)
        }
    }
}

@Composable
fun MainContent(navController: NavController,
                movieList: List<Movie> = getMovies()){
    LazyColumn(modifier = Modifier.padding(12.dp)) {
        items(items = movieList){
            MovieRow(it){ movie ->
                navController.navigate(route = MovieScreens.DetailScreen.name+"/$movie")
            }
        }
    }
}

