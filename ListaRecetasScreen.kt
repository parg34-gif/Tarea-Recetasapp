package com.example.recetasapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListaRecetasScreen(
    recetas: List<Receta>,
    onRecetaClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Recetario Mexicano",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(recetas) { receta ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onRecetaClick(receta.id) } 
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = receta.nombre, style = MaterialTheme.typography.titleLarge)
                    }
                }
            }
        }
    }
}
