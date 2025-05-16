package com.example.safetext.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.safetext.R
import com.example.safetext.presentation.viewmodel.AuthViewmodel
import androidx.compose.runtime.getValue
import com.example.safetext.services.loginstate


@Composable
fun LoginScreen(loginviewmodel: AuthViewmodel , navController: NavController)
{
    val username = remember{ mutableStateOf("") }
    val passwd = remember { mutableStateOf("") }
    val isLoggedIn by loginviewmodel.isLoggedIn.collectAsState()
    /*LaunchedEffect(issloggedin) {
        when(issloggedin){
            is loginstate.LoggedIn ->{
                navController.navigate("home") {
                    popUpTo("login") { inclusive = true }
                }
            }
            /*else -> {
                navController.navigate("login") {
                    popUpTo("home") { inclusive = true }
                }
            }*/
            loginstate.Loading -> {

            }
            loginstate.loggedout -> {
                navController.navigate("login")
            }
        }
    }*/
    LaunchedEffect(isLoggedIn) {
        if (isLoggedIn is loginstate.LoggedIn) {
            navController.navigate("home") {
                popUpTo("login") { inclusive = true }
            }
        }
    }
    Surface(Modifier
        .statusBarsPadding()
        .fillMaxSize()){
        Column(Modifier.fillMaxSize() , verticalArrangement = Arrangement.Center ,
            horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = R.drawable.aoho6l1ywovzb40rbdvj,
                contentDescription = null
            )
            OutlinedTextField(value = username.value, onValueChange = { username.value = it } , label = {Text("Username")})
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(value = passwd.value, onValueChange = { passwd.value = it } , label = {Text("Password")})
            Button(
                onClick = {loginviewmodel.login(username.value,passwd.value)},
            ) {
                Text("Login")
            }
            TextButton(onClick = {navController.navigate("signup")}){ Text("Don't have an account? Sign Up") }
        }
    }
}
