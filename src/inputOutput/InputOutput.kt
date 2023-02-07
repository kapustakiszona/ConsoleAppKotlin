package inputOutput

import inputOutput.MyCommands.Companion.END
import inputOutput.MyCommands.Companion.HELP
import inputOutput.MyCommands.Companion.START
import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    println("Введите вашу команду: ")
    var isStart = true

    while (isStart) {

        val currentCommand = scanner.next()
        checkCommands(currentCommand)

        if (currentCommand == END) {
            isStart = false
        }
    }
}

private fun checkCommands(command: String) {
    when (command) {
        START -> startAnswer()
        HELP -> helpAnswer()
        END -> endAnswer()
        else -> incorrectCommand()
    }
}

private fun startAnswer() {
    println("Привет! \nВведи $HELP, если ты хочешь узнать, какие команды доступны.\nПожалуйста, введи свою команду:  ")
}

private fun helpAnswer() {
    println(
        "Сейчас доступны 3 команды: \n- $START - запустить программу. \n- $HELP - показать доступные команды. \n- $END - закрыть программу." +
                "\nПожалуйста, введи свою команду:  "
    )
}

private fun endAnswer() {
    println("Программа закрыта.\nДо встречи!")
}

private fun incorrectCommand() {
    println("Такой команды не существует!\nВведи $HELP, если ты хочешь узнать, какие команды доступны.")
}

class MyCommands {

    companion object {
        const val START = "/start"
        const val HELP = "/help"
        const val END = "/end"
    }

}