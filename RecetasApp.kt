package com.example.recetasapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun RecetasApp() {
    val navController = rememberNavController()
    val recetasViewModel: RecetasViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        // Ruta 1: Lista de Recetas ("Home")
        composable(route = "home") {
            ListaRecetasScreen(
                recetas = recetasViewModel.listaRecetas,
                onRecetaClick = { id ->
                    navController.navigate("detail/$id")
                }
            )
        }

        // Ruta 2: Detalle de Receta ("Detail" con argumento)
        composable(
            route = "detail/{recetaId}",
            arguments = listOf(navArgument("recetaId") { type = NavType.StringType })
        ) { backStackEntry ->
            val recetaId = backStackEntry.arguments?.getString("recetaId")

            recetaId?.let { id ->
                recetasViewModel.seleccionarRecetaPorId(id)
            }

            DetalleRecetaScreen(
                viewModel = recetasViewModel,
                onVolverClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}