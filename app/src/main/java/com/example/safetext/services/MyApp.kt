package com.example.safetext.services

import androidx.compose.runtime.Composable
import com.example.safetext.presentation.viewmodel.AuthViewmodel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.safetext.presentation.ui.screens.LoginScreen
import com.example.safetext.presentation.ui.screens.SignUpScreen

@Composable
fun MyApp()
{

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            val viewModel: AuthViewmodel = hiltViewModel()
            LoginScreen(viewModel, navController)
        }
        composable("home") {
          // HomeScreen()
        }
        composable("signup") {
            val viewmodel : AuthViewmodel = hiltViewModel()
            SignUpScreen(viewmodel,navController)
        }
    }
}