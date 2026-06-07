package com.example.recetasapp
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class Receta(
    val id: String,
    val nombre: String,
    val ingredientes: String,
    val instrucciones: String
)

class RecetasViewModel : ViewModel() {

    val listaRecetas = listOf(
        Receta("1", "Chilaquiles Verdes", "Totopos, salsa verde, crema, queso, pollo", "1. Freír los totopos. \n2. Bañar en salsa verde. \n3. Decorar con crema y queso."),
        Receta("2", "Tacos al Pastor", "Carne de cerdo, piña, cilantro, cebolla, tortillas", "1. Marinar la carne. \n2. Cocinar a fuego alto. \n3. Servir con piña y verdura."),
        Receta("3", "Enchiladas Potosinas", "Masa con chile, queso, crema", "1. Hacer las tortillas sazonadas. \n2. Rellenar de queso. \n3. Freír levemente.")
    )

    private val _recetaSeleccionada = MutableStateFlow<Receta?>(null)
    val recetaSeleccionada: StateFlow<Receta?> = _recetaSeleccionada.asStateFlow()

    fun seleccionarRecetaPorId(id: String) {
        _recetaSeleccionada.value = listaRecetas.find { it.id == id }
    }
}