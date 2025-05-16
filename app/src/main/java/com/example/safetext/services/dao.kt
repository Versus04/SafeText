package com.example.safetext.services

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.safetext.data.contactEntity

@Dao
interface contactdao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertcontact(contactEntity: contactEntity)
    @Query("select * from contacts")
    suspend fun getcontacts() : List<contactEntity>
    @Query("delete from contacts where username = :username")
    suspend fun deletecontact(username: String)
}