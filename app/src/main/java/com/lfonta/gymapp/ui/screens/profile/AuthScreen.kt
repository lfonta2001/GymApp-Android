package com.lfonta.gymapp.ui.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lfonta.gymapp.ui.theme.GymAppTheme

@Composable
fun RegisterLogin(modifier: Modifier = Modifier) {
    // Agregar una nota al usuario si tiene password manager diciendo los links donde usar las credenciales
    Column{
        var thing: String = "hola"
        TextField(value = thing, onValueChange = { s -> thing = s})
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterLoginPreview() {
    GymAppTheme {
        RegisterLogin()
    }
}