package com.example.safetext.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.safetext.services.authrepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewmodel @Inject constructor(private val repository: authrepository): ViewModel()
{
    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    fun login(email: String, password: String){
        viewModelScope.launch {
            val success = repository.login(email,password)
            if(success)_isLoggedIn.value=true
        }

    }

    fun signUp(email: String, password: String){
        viewModelScope.launch {
          val success =   repository.signUp(email,password)
            if(success)_isLoggedIn.value=true
        }
        fun checkstatus() : Boolean
        {
            return repository.isloggedin()
        }

    }
}