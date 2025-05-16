package com.example.safetext.services

import android.app.Application
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Room
import com.example.safetext.data.contactdatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.sql.Date
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object databasemodule{
    @Provides
    @Singleton
    fun providedatabase(app : Application) : contactdatabase{
        return Room.databaseBuilder(app, contactdatabase::class.java, "contacts_db").build()
    }

    @Provides
    fun providecontactdao(database: contactdatabase): contactdao {
        return database.dao

    }
}