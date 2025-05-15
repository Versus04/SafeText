package com.example.safetext.services

import android.provider.ContactsContract
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

class authrepository {

    private val supabase = SupabaseClientHolder.client

    suspend fun login(mail: String, pass: String): Boolean {
        return try {
            supabase.auth.signUpWith(Email) {
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
            supabase.auth.signUpWith(Email){
                email=mail
                password=pass
            }
            true
        }catch(e: Exception) {
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