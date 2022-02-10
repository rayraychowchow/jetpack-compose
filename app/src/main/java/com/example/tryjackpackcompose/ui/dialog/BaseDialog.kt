package com.example.tryjackpackcompose.ui.dialog

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.tryjackpackcompose.models.dialog.DialogModel

@Composable
fun showBaseDialog(dialogModel: DialogModel) {
    AlertDialog(onDismissRequest = dialogModel.onDismissAction,
        title = { Text(text = dialogModel.title) },
        text = { Text(text = dialogModel.message) },
        confirmButton = {
        Button(onClick = dialogModel.onConfirmAction) {
            Text(text = dialogModel.confirmTitle)
        }
    })
}