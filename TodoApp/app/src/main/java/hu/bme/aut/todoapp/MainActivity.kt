package hu.bme.aut.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import hu.bme.aut.todoapp.screen.TodoListScreen
import hu.bme.aut.todoapp.screen.TodoSummaryScreen
import hu.bme.aut.todoapp.ui.theme.TodoAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TodoAppNavHost()
                }
            }
        }
    }
}

@Composable
fun TodoAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "todolist"
) {
    NavHost(
        modifier = modifier, navController = navController, startDestination = startDestination
    ) {
        composable("todolist") { TodoListScreen(
            onNavigateToSummary = {all, important->
                navController.navigate("todosummary/$all/$important")
            }
        )}

        composable("todosummary/{numalltodo}/{numimportant}",
            arguments = listOf(
                navArgument("numalltodo"){type = NavType.IntType},
                navArgument("numimportant"){type = NavType.IntType})
            ) {
            val numalltodo = it.arguments?.getInt("numalltodo")
            val numimportant = it.arguments?.getInt("numimportant")
            if (numalltodo != null && numimportant != null) {
                TodoSummaryScreen(
                    numalltodo = numalltodo,
                    numimportanttodo = numimportant
                )
            }
        }
    }
}
