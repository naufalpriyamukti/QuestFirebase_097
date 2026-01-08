package com.example.firebasequest097.view.Navigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.firebasequest097.view.EntrySiswaScreen
import com.example.firebasequest097.view.HomeScreen
import com.example.firebasequest097.view.route.DestinasiDetail
import com.example.firebasequest097.view.route.DestinasiEntry
import com.example.firebasequest097.view.route.DestinasiHome
import com.example.firebasequest097.view.DetailSiswaScreen
import com.example.firebasequest097.view.EditSiswaScreen

@Composable
fun DataSiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = {
                    // Navigasi ke detail dengan membawa argumen ID
                    navController.navigate("${DestinasiDetail.route}/$it")
                }
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.navigate(DestinasiHome.route) }
            )
        }
        composable(
            DestinasiDetail.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetail.itemIdArg) {
                type = NavType.StringType
            })
        ){
            {
                DetailSiswaScreen(
                    navigateToEditItem = { navController.navigate("${DestinasiEdit.route}/$it") },
                    navigateBack = { navController.navigate(DestinasiHome.route) }
                )
            }
        }
    }
}