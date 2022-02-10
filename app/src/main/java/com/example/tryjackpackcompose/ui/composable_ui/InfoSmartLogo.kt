package com.example.tryjackpackcompose.ui.composable_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tryjackpackcompose.R

@Composable
fun InfoSmartLogo(modifier: Modifier = Modifier
    .fillMaxWidth()
    .padding(start = 16.dp, end = 16.dp)) {
    Image(
        alignment = Alignment.Center,
        painter = painterResource(R.drawable.img_logo_infosmart_white),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}