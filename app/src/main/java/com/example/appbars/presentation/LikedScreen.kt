package com.example.appbars.presentation

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appbars.data.Body
import com.example.appbars.data.data

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LikedScreen(navController: NavController,
                cardViewModel: CardViewModel,
                ){
    val cardUiState by cardViewModel.uiState.collectAsState()
    Scaffold(
        topBar = {

            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),

                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                    }
                                 },
                title = { Text(text = "Liked Item") })
        }
    ) {
        it->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            contentPadding = it,
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
           // cardUiState.likedCheckList[it.id]
            items(data){
                if (cardUiState.likedCheckList[it.id]) {
                    Box(modifier = Modifier.layoutId(it.id.toString())){
                    LikedList(
                        body = it,
                        like = cardUiState.likedCheckList[it.id])
                    {
                        cardViewModel.updateFunc(id = it.id)
                    }
                    }
                }
                else {
                    Spacer(
                        modifier = Modifier
                            .width(0.dp)
                            .height(0.dp) // or desired height
                    )
                }
            }
        }
    }
}

