package com.example.recetasapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetalleRecetaScreen(
    viewModel: RecetasViewModel,
    onVolverClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val receta by viewModel.recetaSeleccionada.collectAsState()

    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        receta?.let { data ->
            Text(text = data.nombre, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Ingredientes:", style = MaterialTheme.typography.titleMedium)
            Text(text = data.ingredientes, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Instrucciones:", style = MaterialTheme.typography.titleMedium)
            Text(text = data.instrucciones, style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.height(24.dp))

            // 2. Añadimos el botón de regreso
            androidx.compose.material3.Button(
                onClick = onVolverClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Volver a la Lista")
            }
        } ?: run {
            Text(text = "Receta no encontrada", style = MaterialTheme.typography.bodyLarge)
        }
    }
}