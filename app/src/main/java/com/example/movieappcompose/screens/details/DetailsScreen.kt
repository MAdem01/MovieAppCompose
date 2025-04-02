package com.example.movieappcompose.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movieData: String?){
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
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally) {
               Text(
                   text = movieData.toString(),
                   style = MaterialTheme.typography.headlineSmall
               )
           }
       }
   }
}