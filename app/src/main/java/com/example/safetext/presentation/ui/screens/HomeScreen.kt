package com.example.safetext.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.safetext.presentation.viewmodel.AuthViewmodel

@Composable
fun HomeScreen(viewModel: AuthViewmodel = hiltViewModel())
{
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
    }
}