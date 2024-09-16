package cl.bootcamp.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import cl.bootcamp.calculadoraimc.ui.theme.CalculadoraImcTheme
import cl.bootcamp.calculadoraimc.view.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraImcTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    HomeScreen()
                }
            }
        }
    }
}