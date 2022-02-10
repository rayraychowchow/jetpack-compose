package com.example.tryjackpackcompose.ui.inspection

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tryjackpackcompose.base.BaseActivity
import com.example.tryjackpackcompose.ui.theme.TryJackpackComposeTheme

class InspectionActivity: BaseActivity<InspectionViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TryJackpackComposeTheme {
                Content(viewModel)
            }
        }
    }
    
    override val viewModel: InspectionViewModel by viewModels()

    companion object {
        fun start(activity: Activity?) {
            activity?.let {
                it.startActivity(Intent(it, InspectionActivity::class.java))
            }
        }
    }

    @Composable
    fun Content(model: InspectionViewModel = viewModel()) {
        val value by model.ldTextLabel.observeAsState("")
        val buttonTitle by model.ldButtonTitle.observeAsState("")
        Column {
            Text(text = value, color = Color.Black)
            Button(onClick = { model.getFullProjectData() }) {
                Text(text = buttonTitle)
            }
        }
    }
}