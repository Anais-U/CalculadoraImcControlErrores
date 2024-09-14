package cl.bootcamp.calculadoraimc.vistas

import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cl.bootcamp.calculadoraimc.components.InputField
import cl.bootcamp.calculadoraimc.components.MultiButtonSegmented

@Composable
fun HomeScreen() {
    // Crear estados mutables para los valores de entrada
    val age = remember { mutableStateOf("") }
    val height = remember { mutableStateOf("") }
    val weight = remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("Hombre") }
    var imcResult by remember { mutableStateOf("") }

    fun calcularIMC(peso: String, altura: String): String {
        val pesoDouble = peso.toDoubleOrNull()
        val alturaDouble = altura.toDoubleOrNull()?.div(100) // Convertimos de cm a metros

        return if (pesoDouble != null && alturaDouble != null && alturaDouble > 0) {
            val imc = pesoDouble / (alturaDouble * alturaDouble)
            "Tu IMC es: %.2f".format(imc)
        } else {
            "Por favor ingresa valores válidos"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Título
        Text(text = "Calculadora de IMC",
            fontSize = 35.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // MultiButton Segmentado
        MultiButtonSegmented(
            options = listOf("Hombre", "Mujer"),
            selectedOption = selectedGender,
            onOptionSelected = { selectedGender = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Pregunta de Edad
        InputField(
            label = "Edad",
            value = age,
            onValueChange = { age.value = it }
        )

        Spacer(modifier = Modifier.height(16.dp))



        // Pregunta de Altura
        InputField(
            label = "Altura (cm)",
            value = height,
            onValueChange = { height.value = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Pregunta de Peso
        InputField(
            label = "Peso (kg)",
            value = weight,
            onValueChange = { weight.value = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para calcular IMC
        Button(
            onClick = {
                imcResult = calcularIMC(weight.value, height.value)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta, // Color de fondo
                contentColor = Color.White // Color del texto
            )
        ) {
            Text(text = "Calcular IMC")
        }

        // Resultado del IMC
        Text(text = imcResult,
            fontSize = 45.sp
        )

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
