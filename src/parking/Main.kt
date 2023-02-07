package parking

import parking.Command.Companion.CURRENT_STAT
import parking.Command.Companion.ERROR
import parking.Command.Companion.HELP
import parking.Command.Companion.PARK
import parking.Command.Companion.RETURN
import parking.Command.Companion.SHOW_CAR_INFO
import parking.Command.Companion.SHOW_PLACE
import parking.Command.Companion.STAT
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val manager = Manager()
    println("Введите /help, чтобы узнать, какие команды принимает менеджер парковки\nВведите команду: ")

    while (scanner.hasNext()) {
        when (scanner.next()) {
            PARK -> {
                val car = initialized(scanner)
                manager.addCarToParkingPlace(car)
            }
            RETURN -> {
                val ownerName = scanner.nextLine().trim()
                manager.returnCarFromParkingPlace(ownerName)
            }
            SHOW_PLACE -> {
                val number = scanner.next()
                manager.showParkingPlaceByNumber(number)
            }
            SHOW_CAR_INFO -> {
                val place = scanner.next()
                manager.showCarInfoByParkingPlace(place)
            }
            HELP -> {
                manager.printHelp()
            }
            STAT -> {
                manager.printParkingInfo()
            }
            CURRENT_STAT -> {
                manager.printStatistic()
            }
            else -> println(ERROR)
        }
    }

}


fun initialized(scanner: Scanner): Car {
    val car = Car()
    val line = scanner.nextLine().trim()
    val pattern = "^\\w+ \\w+ \\w+ .+$"
    if (!line.matches(pattern.toRegex())) {
        return car
    }
    val values = line.split(" ")
    car.mark = values[0]
    car.color = values[1]
    car.number = values[2]
    car.ownerName = values.drop(3).joinToString(" ")
    if (car.ownerName != car.owner.name) {
        car.owner.name = car.ownerName
    }
    return car
}