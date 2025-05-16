package com.example.safetext.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.safetext.services.contactdao

@Database(entities = [contactEntity::class], version = 1)
abstract class  contactdatabase : RoomDatabase() {
    abstract val dao : contactdao

}