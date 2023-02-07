package parking

class Car(var mark: String, var color: String, var number: String, var ownerName: String) {
    constructor() : this("Unknown", "Unknown", "Unknown", "Unknown")

    val owner = Owner(ownerName)


    fun getCarNumber(): String {
        return number
    }

    override fun toString(): String {
        return "Машина $mark $color $number"
    }
}
