package com.example.tryjackpackcompose.ui.launch

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tryjackpackcompose.R
import com.example.tryjackpackcompose.base.BaseActivity
import com.example.tryjackpackcompose.extension.disposedBy
import com.example.tryjackpackcompose.ui.composable_ui.InfoSmartLogo
import com.example.tryjackpackcompose.ui.main.MainActivity
import com.example.tryjackpackcompose.ui.theme.TryJackpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchActivity: BaseActivity<LaunchViewModel>(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TryJackpackComposeTheme {
                LaunchActivityContent(viewModel)
            }
        }
    }

    override val viewModel: LaunchViewModel by viewModels()

    override fun observeViewModel() {
        super.observeViewModel()
        viewModel.onInitialTimerEnd.doOnNext {
            goToMainActivity()
        }.subscribe()
            .disposedBy(disposeBag)
    }

    private fun goToMainActivity() {
        MainActivity.start(this)
    }
}

@Composable
fun LaunchActivityContent(model: LaunchViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.system_grey_in_bg)),
        verticalArrangement = Arrangement.Center
    ) {
        InfoSmartLogo()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TryJackpackComposeTheme {
        LaunchActivityContent(model = LaunchViewModel())
    }
}