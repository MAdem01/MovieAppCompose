package com.example.movieappcompose.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieappcompose.model.Movie
import com.example.movieappcompose.model.getMovies
import com.example.movieappcompose.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movieId: String?){
   val newMovieList = getMovies().filter{
       it.id == movieId
   }
   Scaffold(topBar = {
       TopAppBar(
           colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black),
           title = {Text(text = "Movies", color = Color.White) },
           navigationIcon = {
               Row(
                   horizontalArrangement = Arrangement.Start,
                   ) {
                   Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                       tint = Color.White,
                       contentDescription = "Arrow Back",
                       modifier = Modifier
                           .clickable {
                               navController.popBackStack()
                           })
                   Spacer(modifier = Modifier.width(120.dp))
               }
           }
       )
   }) {paddingValues ->
       Surface(modifier = Modifier.fillMaxSize()) {
           Column(modifier = Modifier
               .padding(paddingValues),
               verticalArrangement = Arrangement.Top,
               horizontalAlignment = Alignment.CenterHorizontally) {
               MovieRow(movie = newMovieList.first())
               Spacer(modifier = Modifier.height(8.dp))
               HorizontalDivider()
               Text(text = "Movie Images")
               HorizontalScrollableImageView(newMovieList)

           }
       }
   }
}

@Composable
private fun HorizontalScrollableImageView(newMovieList: List<Movie>) {
    LazyRow {
        items(newMovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp)
                    .wrapContentHeight(),
                elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)
            ) {

                AsyncImage(
                    model = image,
                    contentDescription = "Movie Poster",
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}