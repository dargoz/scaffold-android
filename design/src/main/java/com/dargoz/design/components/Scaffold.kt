package com.dargoz.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dargoz.design.theme.MyAppTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Scaffold(
    title: String
) {
    var refreshing = false

    val pullRefreshState = rememberPullRefreshState(refreshing, {
        GlobalScope.launch {
            refreshing = true
            delay(2000)
            refreshing = false
        }

    })
    Column {
        Row(
            modifier = Modifier.fillMaxWidth().background(color = Color.Blue),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "back button")
            }
            Text(title)
            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = {}) {
                Icon(Icons.Filled.Settings, contentDescription = "setting button")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Lock, contentDescription = "setting button")
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)
        ) {

            Card(
                modifier = Modifier
                    .fillMaxSize().pullRefresh(pullRefreshState),
                backgroundColor = Color.White,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            ) {

                Column(Modifier.fillMaxSize()) {

                }


            }
        }
    }
}

@Preview
@Composable
fun ScaffoldPreview() {
    MyAppTheme {
        Scaffold(title = "Hello")
    }
}