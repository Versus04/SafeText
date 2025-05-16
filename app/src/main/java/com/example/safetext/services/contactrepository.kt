package com.example.safetext.services

import com.example.safetext.data.contactEntity
import javax.inject.Inject

class contactrepository @Inject constructor(private val contactdao: contactdao) {
    suspend fun addcontact(contactEntity: contactEntity) = contactdao.insertcontact(contactEntity)
    suspend fun getcontacts(): List<contactEntity> = contactdao.getcontacts()
    suspend fun deleteContact(username: String) = contactdao.deletecontact(username)

}