package com.example.safetext.services

import android.provider.ContactsContract
import android.util.Log
import com.example.safetext.data.MessageDTO
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.user.UserInfo
import io.github.jan.supabase.postgrest.postgrest
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class authrepository @Inject constructor(
    private val supabase: SupabaseClient
) {
    val sender = supabase.auth.currentSessionOrNull()?.user?.id
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
    suspend fun sendmessage( receiveremail:String, message:String): Boolean{
        return try{
            val response = supabase.postgrest.from("mess")
                .insert(
                    mapOf(
                        "sender" to sender,
                        "reciever" to receiveremail,
                        "message" to message,
                        "timestamp" to "now()"
                    )
                )
        true }
        catch (e: Exception){
            Log.e("xyz", "text adding failed", e)
        false}
    }
    suspend fun recievemessage(): List<MessageDTO> {
        return withContext(Dispatchers.IO) {
            val result = supabase.postgrest.from("mess").select {
                "*"
            }.decodeList<MessageDTO>()

            result.forEach { mess ->
                Log.d("sadfasfdf", "${mess.message}")
            }

            result
        }
    }

    fun isloggedin(): UserInfo? {
        return supabase.auth.currentUserOrNull()
    }
    suspend fun logout(){
        supabase.auth.signOut()
    }
}