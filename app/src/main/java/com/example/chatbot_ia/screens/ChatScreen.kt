package com.example.chatbot_ia.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.chatbot_ia.components.AppHeader
import com.example.chatbot_ia.components.MessageInput
import com.example.chatbot_ia.components.MessageList
import com.example.chatbot_ia.model.ModelActivity
import com.example.chatbot_ia.viewmodel.ChatViewModel


@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun ChatScreen(modifier: Modifier = Modifier, viewModel: ChatViewModel) {

    Column(
        modifier = Modifier
    ) {
        AppHeader()
        MessageList(
            modifier= Modifier.weight(1f),
            messageList = viewModel.messageList
        )
        MessageInput(
            onMessageSend = {
                viewModel.sendMessage(it)
            }
        )
    }
}


@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    val mockViewModel = ChatViewModel().apply {
        messageList.add(ModelActivity("Olá", "user"))
        messageList.add(ModelActivity("Oi! Como posso ajudar?", "exemplo"))
    }
        ChatScreen(viewModel = mockViewModel)
}