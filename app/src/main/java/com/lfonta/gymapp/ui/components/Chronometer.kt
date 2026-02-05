package com.lfonta.gymapp.ui.components

import android.os.SystemClock
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lfonta.gymapp.ui.theme.GymAppTheme
import kotlinx.coroutines.delay

@Composable
fun Chronometer(modifier: Modifier = Modifier) {
    var running by remember { mutableStateOf(false) }
    var elapsed by remember { mutableLongStateOf(0L) }

    LaunchedEffect(running) {
        val start = SystemClock.elapsedRealtime() - elapsed
        while (running) {
            elapsed = SystemClock.elapsedRealtime() - start
            delay(100)
        }
    }

    val seconds = elapsed / 1000.0f
    Column {
        Text(String.format("%.1f s", seconds))

        Button(onClick = { running = !running}) {
            Text(if (running) "Pausar" else "Comenzar")
        }
        Button(onClick = {
            running = false
            elapsed = 0
        }) {
            Text("Resetear")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChronometerPreview() {
    GymAppTheme {
        Chronometer()
    }
}