package hu.bme.aut.highlowgame.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.Random

class GameViewModel() : ViewModel() {

    var randomNum by mutableStateOf(0)

    init {
        generateNewNum()
    }

    fun generateNewNum() {
        randomNum = Random(System.currentTimeMillis()).nextInt(2)
    }

}