package cl.bootcamp.calculadoraimc.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.bootcamp.calculadoraimc.model.IMCData
import kotlinx.coroutines.launch

class IMCViewModel : ViewModel() {
    var imcData = mutableStateOf(IMCData())
    var imcResult = mutableStateOf("")

    fun updateGender(gender: String) {
        imcData.value = imcData.value.copy(gender = gender)
    }

    fun updateHeight(height: Float) {
        imcData.value = imcData.value.copy(height = height)
    }

    fun updateWeight(weight: Float) {
        imcData.value = imcData.value.copy(weight = weight)
    }

    fun calculateIMC() {
        viewModelScope.launch {
            val heightInMeters = imcData.value.height / 100
            val imc = imcData.value.weight / (heightInMeters * heightInMeters)
            imcResult.value = "IMC: %.2f".format(imc)
        }
    }
}