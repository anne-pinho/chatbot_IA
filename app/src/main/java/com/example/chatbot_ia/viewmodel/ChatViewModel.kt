package com.example.chatbot_ia.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatbot_ia.model.ModelActivity
import com.example.chatbot_ia.repository.ChatRepository
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    private val chatRepository = ChatRepository(apiKey = "AIzaSyCYsqGMps6iGRryP4Jf2ReuCFVyioqo5OI")

    val messageList = mutableStateListOf<ModelActivity>()

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    fun sendMessage(question: String) {
        viewModelScope.launch {
            try {
                messageList.add(ModelActivity(question, "user"))
                messageList.add(ModelActivity("Escrevendo...", "model"))

                val response = chatRepository.sendMessage(question, messageList)

                messageList.removeLast()
                messageList.add(ModelActivity(response, "model"))
            } catch (e: Exception){
                messageList.removeLast()
                messageList.add(ModelActivity("Erro: ${e.message}", "model"))
            }
        }
    }
}