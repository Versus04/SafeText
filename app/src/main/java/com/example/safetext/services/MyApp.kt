package com.example.safetext.services

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.example.safetext.presentation.viewmodel.AuthViewmodel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.safetext.presentation.ui.screens.HomeScreen
import com.example.safetext.presentation.ui.screens.LoginScreen
import com.example.safetext.presentation.ui.screens.SignUpScreen
import androidx.compose.runtime.getValue
import com.example.safetext.presentation.ui.components.SplashScreen

@Composable
fun MyApp()
{
    val viewmodel : AuthViewmodel = hiltViewModel()
    val loggedin by viewmodel.isLoggedIn.collectAsState()
   val navController = rememberNavController()
    /*NavHost(navController = navController, startDestination = start) {
        composable("login") {
            val viewModel: AuthViewmodel = hiltViewModel()
            LoginScreen(viewModel, navController)
        }
        composable("home") {
           HomeScreen()
        }
        composable("signup") {
            val viewmodel : AuthViewmodel = hiltViewModel()
            SignUpScreen(viewmodel,navController)
        }
    }*/
    when(loggedin){
        is loginstate.Loading ->    {
            SplashScreen(navController)
        }
        else -> {
            NavHost(navController = navController, startDestination = "splash")
            {
                composable("splash"){
                    LaunchedEffect(loggedin) {
                        when(loggedin){
                            is loginstate.LoggedIn -> {
                                navController.navigate("home") {
                                    popUpTo("splash") { inclusive = true }
                                }
                            }
                            is loginstate.loggedout -> {navController.navigate("login")}
                            else -> {}
                        }
                    }
                    SplashScreen(navController)
                }
                composable("login"){
                    LoginScreen(viewmodel,navController)
                }
                composable("signup") {
                    SignUpScreen(viewmodel, navController)
                }
                composable("home"){
                    HomeScreen()
            }
        }
    }
}
}