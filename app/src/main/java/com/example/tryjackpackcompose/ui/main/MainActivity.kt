package com.example.tryjackpackcompose.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tryjackpackcompose.R
import com.example.tryjackpackcompose.base.BaseActivity
import com.example.tryjackpackcompose.enums.LoginPageLiveDataType
import com.example.tryjackpackcompose.extension.disposedBy
import com.example.tryjackpackcompose.ui.composable_ui.InfoSmartLogo
import com.example.tryjackpackcompose.ui.dialog.showBaseDialog
import com.example.tryjackpackcompose.ui.inspection.InspectionActivity
import com.example.tryjackpackcompose.ui.theme.TryJackpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<MainViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TryJackpackComposeTheme {
                Content(viewModel)
            }
        }

        viewModel.onProjectLoaded.doOnNext {
            InspectionActivity.start(this)
        }.subscribe({}, {
            print(it)
        }).disposedBy(disposeBag)
    }

    override val viewModel: MainViewModel by viewModels()

    companion object {
        fun start(activity: Activity?) {
            activity?.let {
                it.startActivity(Intent(it, MainActivity::class.java))
            }
        }
    }
}

@Composable
fun Content(model: MainViewModel = viewModel()) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.system_grey_in_bg))
        .padding(top = 20.dp)
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            ) {
            InfoSmartLogo()
            InputFieldTitleOnTop(
                "LOGIN EMAIL",
                color = Color.White,
                model.getStringLiveData(LoginPageLiveDataType.LOGIN_EMAIL),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            )
            InputFieldTitleOnTop(
                "PASSWORD",
                color = Color.White,
                model.getStringLiveData(LoginPageLiveDataType.LOGIN_PASSWORD),
                isPasswordField = true
            )
            WrongLabel(
                liveData = model.getStringLiveData(LoginPageLiveDataType.WRONG_PASSWORD),
                visibleLiveData = model.getLdShowError()
            )
            CheckBox(
                checked = model.ldRememberLoginEmail,
                title = model.ldRememberLoginEmailTitle
            )
            LoginButton(title = "LOGIN", onCLick = { model.onLoginClicked() })
            TextButton(title = "FORGOT PASSWORD", onCLick = { model.onForgotPasswordClicked() })
            TextButton(
                title = "SIGN UP A NEW ACCOUNT",
                onCLick = { model.onSignUpAccountClicked() })
        }

        Column(modifier = Modifier.padding(16.dp)) {
            TextLabel("version")
            TextLabel("Copyright Copyright Copyright Copyright Copyright Copyright Copyright Copyright")
        }

        val needShowSignUpAccountDialog by model.ldOnShowSignUpAccountDialog.observeAsState()

        needShowSignUpAccountDialog?.let { showBaseDialog(dialogModel = it) }
    }
}

@Composable
fun InputFieldTitleOnTop(
    title: String,
    color: Color = Color.White,
    liveData: MutableLiveData<String>,
    isPasswordField: Boolean = false,
    maxLine: Int = 1,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp)
) {
    val value by liveData.observeAsState("")
    OutlinedTextField(
        value = value,
        onValueChange = {
            liveData.value = it
        },
        modifier = modifier,
        label = { Text(text = title, color = color, fontSize = 14.sp) },
        colors = TextFieldDefaults.outlinedTextFieldColors(textColor = color),
        visualTransformation = if (!isPasswordField) VisualTransformation.None else PasswordVisualTransformation(),
        maxLines = maxLine
    )
}

@Composable
fun WrongLabel(liveData: MutableLiveData<String>,
               visibleLiveData: MutableLiveData<Boolean>,
               color: Color = Color.Red) {
    val text by liveData.observeAsState("")
    val visible by visibleLiveData.observeAsState(false)

//    if (visible == true) {
        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
            text = text, color = color)
//    }
}

@Composable
fun CheckBox(checked: MutableLiveData<Boolean>, title: MutableLiveData<String>) {
    val checkedState by checked.observeAsState(false)
    val labelTitle by title.observeAsState("")
    Row(modifier = Modifier
        .height(44.dp)
        .fillMaxSize()
        .padding(start = 20.dp, end = 20.dp)
        .clickable {
            checked.value = !checkedState
        },
    verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checkedState, onCheckedChange = {
            checked.value = !checkedState
        })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = labelTitle, color = Color.White)
    }
}

@Composable
fun LoginButton(title: String, onCLick: () -> Unit) {
    Button(onClick = onCLick,
        contentPadding = PaddingValues(20.dp, 12.dp, 20.dp, 12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 10.dp, end = 20.dp),
    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
        Text(text = title)
    }
}

@Composable
fun TextButton(title: String, onCLick: () -> Unit) {
    TextButton(onClick = onCLick,
        contentPadding = PaddingValues(20.dp, 12.dp, 20.dp, 12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 10.dp, end = 20.dp),) {
        Text(text = title)
    }
}

@Composable
fun TextLabel(title: String) {
    Text(text = title,
        color = Color.White,
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TryJackpackComposeTheme {
        Content(model = MainViewModel())
    }
}