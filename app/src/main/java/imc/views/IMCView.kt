package imc.views

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobile1project.R
import imc.viewmodels.IMCViewModel

@Composable
fun IMCView(viewModel: IMCViewModel = viewModel()) {
    val context = LocalContext.current
    val weight by viewModel.weight.collectAsState()
    val height by viewModel.height.collectAsState()
    val imcResult by viewModel.imcResult.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Imagen del termómetro
        Image(
            painter = painterResource(id = R.drawable.termometro),
            contentDescription = "Termómetro",
            modifier = Modifier.size(100.dp)
        )

        // Campo para temperatura en Celsius
        OutlinedTextField(
            value = weight,
            onValueChange = { viewModel.weight.value = it },
            label = { Text("Ingrese temperatura en °C") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )

        // Botón para convertir a Fahrenheit
        Button(
            onClick = { viewModel.calculateIMC(context) },
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        ) {
            Text("Convertir a °F")
        }

        // Resultado de la conversión
        if (imcResult.isNotEmpty()) {
            Text(
                text = "Resultado: $imcResult °F",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IMCViewPreview() {
    IMCView()
}
