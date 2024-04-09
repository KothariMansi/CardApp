package com.example.appbars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appbars.data.Body
import com.example.appbars.presentation.BodyItem
import com.example.appbars.presentation.AddScreen
import com.example.appbars.presentation.CardViewModel
import com.example.appbars.presentation.MyApp
import com.example.appbars.ui.theme.AppBarsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {

            AppBarsTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController  = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainScreen") {
                        composable("MainScreen") {
                            MyApp(navController = navController)
                        }

                        composable("AddScreen") {
                            AddScreen(navController = navController)
                        }
                    }
                    //MyApp()
                }
            }
        }
    }
}


@Composable
fun BodyList(
     body: Body,
     cardViewModel: CardViewModel = viewModel()
){
    val cardUiState by cardViewModel.uiState.collectAsState()
    BodyItem(body.drawableRes, body.stringRes,  cardUiState.liked) { cardViewModel.updateFun() }
}
