package imc.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.mobile1project.R

class IMCViewModel : ViewModel() {
    var weight = MutableStateFlow("")
    var height = MutableStateFlow("")
    private val _imcResult = MutableStateFlow("")
    val imcResult = _imcResult.asStateFlow()

    fun calculateIMC(context: Context) {
        val celsiusValue = weight.value.toFloatOrNull()
        _imcResult.value = if (celsiusValue != null) {
            "${(celsiusValue * 9 / 5) + 32}"
        } else {
            context.getString(R.string.invalid_input)
        }
    }
}

