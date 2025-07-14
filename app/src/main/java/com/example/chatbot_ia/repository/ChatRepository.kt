package com.example.chatbot_ia.repository

import com.example.chatbot_ia.model.ModelActivity
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content

class ChatRepository(private val apiKey: String) {
    private val generativeModel: GenerativeModel = GenerativeModel(
        apiKey = apiKey,
        modelName = "gemini-2.0-flash"
    )

    suspend fun sendMessage(question: String, messageList: List<ModelActivity>): String {
        val chat = generativeModel.startChat(
            history = messageList.map {
                content(it.role) { text(it.message) }
            }.toList()
        )
        val response = chat.sendMessage(question)
        return response.text.toString()
    }
}