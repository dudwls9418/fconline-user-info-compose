package com.fconline.user.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fconline.user.R
import com.fconline.user.presentation.theme.Fconline_userTheme
import com.fconline.user.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Fconline_userTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EditText()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditText() {
    val viewModel = hiltViewModel<MainViewModel>()
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            modifier = Modifier.fillMaxWidth().weight(4f),
            placeholder = { Text(stringResource(R.string.nickname_hint)) },
            singleLine = true
        )
        Button(
            modifier = Modifier.width(50.dp).weight(1f),
            onClick = {
                viewModel.getUserId(text.text)
            }) {
            Text("완료")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Fconline_userTheme {
        EditText()
    }
}