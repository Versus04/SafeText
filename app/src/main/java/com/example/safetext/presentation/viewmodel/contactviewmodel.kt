package com.example.safetext.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.safetext.data.contactEntity
import com.example.safetext.services.contactrepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class contactviewmodel @Inject constructor(private val contactrepository: contactrepository)
    : ViewModel()
{
    private val _contacts = MutableStateFlow<List<contactEntity>>(emptyList())
    val contacts : StateFlow<List<contactEntity>> = _contacts
    fun loadcontacts(){
        viewModelScope.launch{ _contacts.value = contactrepository.getcontacts() }
    }
    fun deletecontact(username : String){
        viewModelScope.launch { contactrepository.deleteContact(username)
        loadcontacts()}
    }
    fun addcontact(contactEntity: contactEntity){
        viewModelScope.launch { contactrepository.addcontact(contactEntity)


            loadcontacts()}
    }
    init {
        loadcontacts()
    }

}