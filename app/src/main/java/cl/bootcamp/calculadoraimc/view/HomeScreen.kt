package cl.bootcamp.calculadoraimc.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import cl.bootcamp.calculadoraimc.components.CalcButton
import cl.bootcamp.calculadoraimc.components.ConfirmButton
import cl.bootcamp.calculadoraimc.components.InputField
import cl.bootcamp.calculadoraimc.components.MultiButtonSegmented
import cl.bootcamp.calculadoraimc.viewmodel.IMCViewModel

@Composable
fun HomeScreen(viewModel: IMCViewModel = viewModel()) {
    val imcModel = viewModel.imcModel.value // Acceder al modelo de IMC
    val imcResult = viewModel.imcResult.value
    val showWarning = viewModel.showWarning.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Título
        Text(
            text = "Calculadora de IMC",
            fontSize = 22.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // MultiButton Segmentado para el género
        MultiButtonSegmented(
            options = listOf("Hombre", "Mujer"),
            selectedOption = imcModel.gender,
            onOptionSelected = { viewModel.updateGender(it) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Input para Edad
        InputField(
            label = "Edad",
            value = imcModel.age, // Pasar directamente el valor de edad
            onValueChange = { viewModel.updateAge(it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Input para Altura
        InputField(
            label = "Altura (cm)",
            value = imcModel.height, // Pasar directamente el valor de altura
            onValueChange = { viewModel.updateHeight(it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Input para Peso
        InputField(
            label = "Peso (kg)",
            value = imcModel.weight, // Pasar directamente el valor de peso
            onValueChange = { viewModel.updateWeight(it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para calcular IMC
        CalcButton(onClick = { viewModel.calcularIMC() })

        Spacer(modifier = Modifier.height(16.dp))

        // Resultado del IMC
        Text(text = imcResult, fontSize = 35.sp)

        // Mostrar el modal de advertencia si hay error
        if (showWarning) {
            AlertDialog(
                onDismissRequest = { viewModel.dismissWarning() },
                confirmButton = {
                    ConfirmButton(onClick = { viewModel.dismissWarning() })  // Usando el botón personalizado
                },
                title = {
                    Text(
                        text = "¡Cuidado!",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                },
                text = {
                    Text(
                        text = "No olvides llenar todos los campos con datos correctos.",
                        fontSize = 18.sp
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}





