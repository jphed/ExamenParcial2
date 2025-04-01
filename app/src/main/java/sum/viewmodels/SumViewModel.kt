package sum.viewmodels

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import sum.views.SumAppView

class SumViewModel : ViewModel() {
    var number1 by mutableStateOf(TextFieldValue(""))
    var number2 by mutableStateOf(TextFieldValue(""))
    var result by mutableStateOf(0)

    fun calculateSum() {
        val num1 = number1.text.toIntOrNull() ?: 0
        val num2 = number2.text.toIntOrNull() ?: 0
        result = num1 + num2
    }
}