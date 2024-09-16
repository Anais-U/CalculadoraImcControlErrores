package cl.bootcamp.calculadoraimc.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import cl.bootcamp.calculadoraimc.model.ImcModel
import kotlin.math.pow

class IMCViewModel : ViewModel() {
    val imcModel: MutableState<ImcModel> = mutableStateOf(ImcModel())
    var imcResult: MutableState<String> = mutableStateOf("")
    var showWarning: MutableState<Boolean> = mutableStateOf(false) // Inicializar correctamente

    fun calcularIMC() {
        val height = imcModel.value.height.toFloatOrNull()
        val weight = imcModel.value.weight.toFloatOrNull()

        if (height != null && weight != null && height > 0) {
            val imc = weight / (height / 100).pow(2)
            imcResult.value = "Tu IMC es: %.2f".format(imc)
        } else {
            // Mostrar el modal si los datos no son válidos
            showWarning.value = true
        }
    }

    fun dismissWarning() {
        showWarning.value = false
    }

    fun updateAge(newAge: String) {
        imcModel.value = imcModel.value.copy(age = newAge)
    }

    fun updateGender(newGender: String) {
        imcModel.value = imcModel.value.copy(gender = newGender)
    }

    fun updateHeight(newHeight: String) {
        imcModel.value = imcModel.value.copy(height = newHeight)
    }

    fun updateWeight(newWeight: String) {
        imcModel.value = imcModel.value.copy(weight = newWeight)
    }
}
