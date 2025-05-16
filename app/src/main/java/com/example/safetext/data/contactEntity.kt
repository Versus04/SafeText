package com.example.safetext.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class contactEntity(@PrimaryKey val username : String, val displayname : String)