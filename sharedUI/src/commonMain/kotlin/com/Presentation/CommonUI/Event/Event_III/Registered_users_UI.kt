package com.Presentation.CommonUI.Event.Event_III

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.localdatabase.TraderDao
import kotlin.collections.emptyList

@Composable
fun RegisteredUsersScreen(traderDao: TraderDao) {
    // Collect the SQLite data as a Compose state
    println("RegisteredUsersScreen composed")
    val traders by traderDao.getAllTraders().collectAsState(initial = emptyList())
    Text("trader count = ${traders.size}", color = Color.Yellow)
    LazyColumn(modifier = Modifier.fillMaxSize().padding(all = 16.dp)) {
        items(traders, key = { it.id }) { trader ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = trader.name)
                    Text(text = "IEC: ${trader.iec_number}")
                    Text(text = "Equipment: ${trader.equipment}")
                }
            }
        }
    }
}