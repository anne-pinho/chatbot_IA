package com.example.chatbot_ia.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatbot_ia.model.Message
import com.example.chatbot_ia.ui.theme.Chatbot_IATheme

@Composable
fun ChatScreen(modifier: Modifier = Modifier) {
    val messages = remember { mutableStateListOf<Message>() }
    var currentInput by remember { mutableStateOf("Olá, como posso ajudar?") }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn( // para listar mensagens
            modifier = Modifier.weight(1f),
            reverseLayout = true
        ) { items(messages.reversed()) { message ->
//            Text(
//                text =
//            )

        }
        }
        TextField(
            value = currentInput,
            onValueChange = { currentInput = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
            // textStyle =  MaterialTheme.typography.fon,
        )
        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.End)

        ) {
            Text("Enviar")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Chatbot_IATheme {
        ChatScreen()
    }
}