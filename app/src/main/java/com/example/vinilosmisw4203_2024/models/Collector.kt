package com.example.vinilosmisw4203_2024.models

import android.provider.ContactsContract.CommonDataKinds.Email

data class Collector(
    val id: Int,
    val name: String,
    val telephone: String,
    val email: Email,
)
