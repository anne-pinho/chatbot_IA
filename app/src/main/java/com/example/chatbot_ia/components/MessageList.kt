package com.example.chatbot_ia.components

import android.graphics.ColorSpace.Model
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatbot_ia.model.ModelActivity


@Composable
fun MessageList(
    modifier: Modifier = Modifier,
    messageList: List<ModelActivity>
) {
    if (messageList.isEmpty()) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Posso ajudar você?",
                fontSize = 22.sp
            )
        }
    } else {
        LazyColumn(
            modifier = modifier,
            reverseLayout = true
        ) {
            items(messageList.reversed()) { message ->
                MessageRow(messageModel = message)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessageListPreview() {
    MessageList(
        messageList = listOf(
            ModelActivity("Olá", "Usuário"),
             ModelActivity("Oi, como posso ajudar?", "exemplo")
        )
    )
}


