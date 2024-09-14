package cl.bootcamp.calculadoraimc.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CalcButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Calcular IMC")
    }
}
