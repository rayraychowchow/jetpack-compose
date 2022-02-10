package com.example.tryjackpackcompose.models.dialog

class DialogModel constructor(val title: String,
                              val message: String,
                              val confirmTitle: String,
                              val dismissTitle: String,
                              val onDismissAction: (() -> Unit) = {},
                              val onConfirmAction: (() -> Unit) = {}) {
}