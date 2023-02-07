package parking

/*


Здесь я выбрал object (синглтон?), так как посчитал, что объект Парковка должен быть только один


*/
object Parking {

    private val FREE = null

    val places: MutableMap<String, Car?> = mutableMapOf(
        "P1" to FREE,
        "P2" to FREE,
        "P3" to FREE,
        "P4" to FREE,
        "P5" to FREE,
        "P6" to FREE,
        "P7" to FREE,
        "P8" to FREE,
        "P9" to FREE,
        "P10" to FREE,
        "P11" to FREE,
        "P12" to FREE,
        "P13" to FREE,
        "P14" to FREE,
        "P15" to FREE,
        "P16" to FREE,
        "P17" to FREE,
        "P18" to FREE,
        "P19" to FREE,
        "P20" to FREE,
    )

    fun getInfo() {
        places.forEach { (key, value) ->
            if (value == FREE) {
                println("$key = Свободно")
            } else {
                println("$key = $value")
            }
        }
    }

    fun findFreePlace(): String {
        var myKey  = ""
        for ((key, value) in places) {
            if (value == FREE) {
                myKey = key
                break
            }
        }
        return myKey
    }

    fun makePlaceFree(): Nothing? {
        return FREE
    }

}