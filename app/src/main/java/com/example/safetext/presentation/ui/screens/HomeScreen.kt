package com.example.safetext.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.safetext.presentation.viewmodel.AuthViewmodel
import com.example.safetext.services.loginstate
import androidx.compose.runtime.getValue
import com.example.safetext.data.MessageDTO

@Composable
fun HomeScreen(viewModel: AuthViewmodel = hiltViewModel() , navController: NavController)
{
    val isLoggedIn by viewModel.isLoggedIn.collectAsState()
    LaunchedEffect(isLoggedIn) {
        if (isLoggedIn is loginstate.loggedout) {
            navController.navigate("login")
        }
    }
    Column(Modifier.fillMaxSize().statusBarsPadding()) {
        Text("Welcome Home")
        Button(onClick = {
            viewModel.sendmessage(receiver = "versus@x.com" , message = "maze me?")
        }) {
            Text("sendmessage")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {viewModel.logout()}) {
            Text("Logout")
        }
        var messages = emptyList<MessageDTO>()
        Button(onClick = {messages=viewModel.getmessage()}) {
                Text("getmessage")
        }
        Text(messages.size.toString())




}
}