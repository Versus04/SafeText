package com.example.safetext.data

import kotlinx.serialization.Serializable

@Serializable
data class MessageDTO(val sender : String , val reciever : String , val message : String , val timestamp : String)
