package hu.bme.aut.highlowgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import hu.bme.aut.highlowgame.ui.screen.gamescreen.GameScreen
import hu.bme.aut.highlowgame.ui.screen.help.HelpScreen
import hu.bme.aut.highlowgame.ui.screen.mainmenu.MainScreen
import hu.bme.aut.highlowgame.ui.theme.HighLowGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HighLowGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyAppNavHost()
                }
            }
        }
    }
}

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "mainmenu"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("mainmenu") {MainScreen(
            onNavigateToGame = {
                var upper = 10
                navController.navigate("game?upperBound=$upper") },
            onNavigateToHelp = {
                val helpText = "Use the buttons to play the game"
                navController.navigate("help/$helpText")
            }
        )}

        //composable("game?upperBound={upperBound}") {
        //    GameScreen()
        //}
        composable("game?upperBound={upperBound}",
            arguments = listOf(navArgument("upperBound") {
                defaultValue = 3
                type = NavType.IntType })
        ) { GameScreen() }


        composable("help/{helptext}",
            arguments = listOf(navArgument("helptext"){
                type = NavType.StringType})
        ) {

            val helpText = it.arguments?.getString("helptext")
            helpText?.let {// if helpText is not null, then open HelpScreen
                HelpScreen(helpText = helpText)
            }
        }
    }
}
