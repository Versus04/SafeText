package com.example.safetext.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.safetext.services.authrepository
import kotlinx.coroutines.launch

class loginviewmodel(private val repository: authrepository) : ViewModel() {

}