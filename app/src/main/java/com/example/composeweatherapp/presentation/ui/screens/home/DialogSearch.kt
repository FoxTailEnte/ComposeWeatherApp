package com.example.composeweatherapp.presentation.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun DialogSearch(vm: HomeViewModel) {
    val text = remember {
        mutableStateOf("")
    }
    AlertDialog(onDismissRequest = {
        vm.searchClick(false)
    },
        confirmButton = {
            TextButton(onClick = {
                vm.getData(text.value)
                vm.searchClick(false)
            }) {
                Text(text = "Ok")

            }
        },
        dismissButton = {
            TextButton(onClick = {
                vm.searchClick(false)
            }) {
                Text(text = "Cancel")
            }
        },
        title = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Add city for searching")
                TextField(value = text.value, onValueChange = {
                    text.value = it
                })
            }
        })
}