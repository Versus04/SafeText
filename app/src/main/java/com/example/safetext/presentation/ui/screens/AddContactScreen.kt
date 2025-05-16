package com.example.safetext.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.safetext.presentation.viewmodel.AuthViewmodel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp

@Composable
fun AddContactScreen(viewmodel: AuthViewmodel , navController: NavController)
{
    var username by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Icon(imageVector = Icons.Default.AccountCircle , contentDescription = null)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Add Contact")
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(label = {Text("Username")}, value = username, onValueChange = {username=it})
        ElevatedButton(
            onClick = {},
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onBackground)
        ) {
            Text("Add")
        }
        ElevatedButton(
            onClick = {navController.navigate("home")},
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onBackground)
        ) {
            Text("Go Back")
        }
    }

    }
