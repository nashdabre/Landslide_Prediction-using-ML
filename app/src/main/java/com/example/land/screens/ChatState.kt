package com.example.land.screens

import android.graphics.Bitmap
import com.example.land.data.Chat


data class ChatState (
    val chatList: MutableList<Chat> = mutableListOf(),
    val prompt: String = "",
    val bitmap: Bitmap? = null
)