package com.example.safetext.services

import android.provider.ContactsContract
import android.util.Log
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import jakarta.inject.Inject

class authrepository @Inject constructor(
    private val supabase: SupabaseClient
) {
    suspend fun login(mail: String, pass: String): Boolean {
        return try {
            supabase.auth.signInWith(Email) {
                email = mail
                password = pass
            }

            true
        } catch (e: Exception) {
            false
        }
    }
    suspend fun signUp(mail: String, pass: String): Boolean {
        return try {
            val response = supabase.auth.signUpWith(Email) {
                email = mail
                password = pass
            }
            Log.d("AuthRepo", "Signup successful: $response")
            true
        } catch (e: Exception) {
            Log.e("AuthRepo", "Signup failed", e)
            false
        }
    }

    fun isloggedin() : Boolean{
        return supabase.auth.currentUserOrNull()!=null
    }
    suspend fun logout(){
        supabase.auth.signOut()
    }
}