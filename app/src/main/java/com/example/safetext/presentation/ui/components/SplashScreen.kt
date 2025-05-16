package com.example.safetext.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.safetext.R
import com.example.safetext.presentation.viewmodel.AuthViewmodel
import com.example.safetext.services.loginstate
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import io.github.jan.supabase.realtime.Column
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, viewModel: AuthViewmodel = hiltViewModel()) {
    val loginState by viewModel.isLoggedIn.collectAsState()
    LaunchedEffect(loginState) {

            when (loginState) {
                is loginstate.LoggedIn -> {
                    navController.navigate("home") {
                        popUpTo("splash") { inclusive = true }
                    }
                }

                is loginstate.loggedout -> {
                    navController.navigate("login") {
                        popUpTo("splash") { inclusive = true }
                    }
                }

                is loginstate.Loading -> {
                    // No navigation during loading
                }
            }

    }

   Column(Modifier.fillMaxSize() , verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally) {
       AsyncImage(model = R.drawable.aoho6l1ywovzb40rbdvj, contentDescription = null)
       CircularProgressIndicator()
   }
}
