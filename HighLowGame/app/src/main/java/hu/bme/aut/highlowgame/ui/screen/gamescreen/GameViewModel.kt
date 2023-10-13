package hu.bme.aut.highlowgame.ui.screen.gamescreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import java.util.Random

class GameViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var randomNum by mutableStateOf(0)
    var counter by mutableStateOf(0)

    var upperBound by mutableStateOf(3)


    init {
        savedStateHandle.get<Int>("upperBound")?.let {
            upperBound = it
        }

        generateNewNum()
    }

    fun generateNewNum() {
        randomNum = Random(System.currentTimeMillis()).nextInt(upperBound)
        counter = 0
    }

    fun incCounter() {
        counter++
    }

}