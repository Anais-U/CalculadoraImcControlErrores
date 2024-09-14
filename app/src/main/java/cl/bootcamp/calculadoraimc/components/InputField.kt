package cl.bootcamp.calculadoraimc.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InputField(
    label: String,
    value: MutableState<String>,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value.value, // Aquí usamos el valor del MutableState
        onValueChange = { newValue ->
            value.value = newValue
            onValueChange(newValue) // Llamamos a la función pasada como parámetro para manejar los cambios
        },
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number) // Acepta solo números
    )
}

@Preview(showBackground = true)
@Composable
fun InputFieldPreview() {
    // Para el preview usamos remember para crear un estado mutable
    val textState = remember { mutableStateOf("") }

    InputField(
        label = "Altura (cm)", // Ejemplo de label
        value = textState, // Estado mutable de ejemplo
        onValueChange = {} // No necesitamos manejar cambios en el preview
    )
}
