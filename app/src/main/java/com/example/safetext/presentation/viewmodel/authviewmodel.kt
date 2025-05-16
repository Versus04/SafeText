package com.example.safetext.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.safetext.services.authrepository
import com.example.safetext.services.loginstate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewmodel @Inject constructor(private val repository: authrepository): ViewModel()
{

    private val _isLoggedIn = MutableStateFlow<loginstate>(loginstate.Loading)
    val isLoggedIn: StateFlow<loginstate> = _isLoggedIn

    fun login(email: String, password: String){
        viewModelScope.launch {
            val success = repository.login(email,password)
            if(success)_isLoggedIn.value= loginstate.LoggedIn
        }

    }

    fun signUp(email: String, password: String){
        viewModelScope.launch {
          val success =   repository.signUp(email,password)
            if(success)_isLoggedIn.value= loginstate.LoggedIn
        }}
    fun checkstatus() {
        viewModelScope.launch{
            delay(1500)
            val user = repository.isloggedin()
            _isLoggedIn.value = if (user != null) loginstate.LoggedIn else loginstate.loggedout
        }
    }

    init {
        viewModelScope.launch{ delay(2000) }
        checkstatus()
    }
}