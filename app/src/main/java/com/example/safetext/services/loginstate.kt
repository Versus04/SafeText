package com.example.safetext.services

sealed class loginstate {
    object Loading : loginstate()
    object LoggedIn: loginstate()
    object loggedout : loginstate()
}