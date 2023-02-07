package parking

import parking.Command.Companion.HELP
import parking.Command.Companion.PARK
import parking.Command.Companion.RETURN
import parking.Command.Companion.SHOW_CAR_INFO
import parking.Command.Companion.SHOW_PLACE

class Manager {
    private val parking = Parking
    private var statistics: Int = 0


    fun addCarToParkingPlace(car: Car) {
        if (car.mark == "Unknown") {
            println("Ошибка! Некорректные данные.")
        } else if (isCarParked(car)) {
            println("Такая машина уже припаркована!")
        } else {
            val key = parking.findFreePlace()
            parking.places[key] = car
            println("$car припаркована на место $key")
            ++statistics
        }
    }

    fun returnCarFromParkingPlace(ownerName: String) {
        lateinit var myCar: String
        for ((key, value) in parking.places) {

            if (value?.ownerName == ownerName) {
                myCar = value.toString()
                parking.places[key] = Parking.makePlaceFree()
                println("$myCar уехала!")
                break
            } else {
                println("Неверное имя!")
                break
            }
        }
    }

    fun showParkingPlaceByNumber(number: String) {
        lateinit var myPlace: String
        for ((key, value) in parking.places) {
            if (value?.getCarNumber() == number) {
                myPlace = key
                println("Машина припаркована на месте $myPlace")
                break
            } else {
                println("Номер неверный либо не существует!")
                break
            }
        }
    }

    fun showCarInfoByParkingPlace(place: String) {
        lateinit var myCar: String
        for ((key, value) in parking.places) {
            if (key == place) {
                myCar = value.toString()
                println("На месте $place находится $myCar")
                break
            } else {
                println("Место свободно либо неверно указано!")
                break
            }
        }
    }


    fun printHelp() {
        println(
            "Список доступных операций:\n-$PARK" +
                    " - припарковать автомобиль, используя следующие данные:\n  " +
                    " * Марка\n   * Цвет\n   * Номер\n   * Имя и фамилия владельца\n-$RETURN - забрать автомобиль," +
                    " используя имя и фамилию владельца\n" +
                    "-$SHOW_CAR_INFO - показать информацию о автомобиле, используя номер парковочного места\n" +
                    "-$SHOW_PLACE - показать место, на котором припаркован автомобиль, используя номер\n" +
                    "-$HELP - получить информацию о всех доступных операциях"
        )
    }

    fun printParkingInfo() {
        parking.getInfo()
    }

    fun printStatistic() {
        println("За текущий сеанс было припарковано: $statistics автомобилей")
    }

    private fun isCarParked(car: Car): Boolean {
        var result = false
        for ((key, value) in parking.places) {
            if (car == value) {
                result = true
                break
            }
        }
        return result
    }
}