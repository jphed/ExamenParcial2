package sum.views

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
import sum.viewmodels.SumViewModel

@Composable
fun SumAppView(sumViewModel: SumViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = sumViewModel.number1,
            onValueChange = { sumViewModel.number1 = it },
            label = { Text("Número 1") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = sumViewModel.number2,
            onValueChange = { sumViewModel.number2 = it },
            label = { Text("Número 2") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { sumViewModel.calculateSum() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sumar")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Resultado: ${sumViewModel.result}", style = MaterialTheme.typography.headlineMedium)
    }
}