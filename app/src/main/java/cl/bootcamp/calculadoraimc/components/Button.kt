package cl.bootcamp.calculadoraimc.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun CalcButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Magenta, // Color de fondo del botón
            contentColor = Color.White // Color del texto del botón
        )
    ) {
        Text("Calcular IMC")
    }

}

@Composable
fun ConfirmButton(onClick: () -> Unit, buttonText: String = "Comprendido") {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Magenta,  // Color de fondo
            contentColor = Color.White       // Color del texto
        )
    ) {
        Text(buttonText)
    }
}
