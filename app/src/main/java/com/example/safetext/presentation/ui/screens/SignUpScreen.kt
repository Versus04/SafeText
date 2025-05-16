package com.example.safetext.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.safetext.R
import androidx.compose.runtime.getValue

import com.example.safetext.presentation.viewmodel.AuthViewmodel
import com.example.safetext.services.loginstate

@Composable
fun SignUpScreen(signUpViewModel: AuthViewmodel , navcontroller: NavController)
{
    val username = remember{ mutableStateOf("") }
    val passwd = remember { mutableStateOf("") }
    val cpasswd = remember { mutableStateOf("") }
    val issloggedin by signUpViewModel.isLoggedIn.collectAsState()
    LaunchedEffect(issloggedin) {
        when(issloggedin){
            is loginstate.LoggedIn ->{
                navcontroller.navigate("home") {
                    popUpTo("login") { inclusive = true }
                }
            }
            else -> {
                navcontroller.navigate("login")
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
            OutlinedTextField(value = passwd.value, onValueChange = { passwd.value = it } , label = {Text("Enter your password")})
            OutlinedTextField(value = cpasswd.value, onValueChange = { cpasswd.value = it } , label = {Text("Enter your password again")})
            Spacer(Modifier.height(8.dp))
            Button(
                onClick = {signUpViewModel.signUp(username.value,passwd.value)
                          Log.d("SignUpScreen", passwd.value)
                          },
            ) {
                Text("Sign Up")
            }
            TextButton(onClick = {navcontroller.navigate("login")}) { Text("Already have an account?Log In") }
        }
    }
}