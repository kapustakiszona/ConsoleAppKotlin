package parking

class Car(var mark: String, var color: String, var number: String, var ownerName: String) {
    constructor() : this("Unknown", "Unknown", "Unknown", "Unknown")

    val owner = Owner(ownerName)


    fun getCarNumber(): String {
        return number
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Car) {
            return false
        }
        return mark == other.mark && color == other.color && number == other.number && ownerName == other.ownerName
    }

    override fun toString(): String {
        return "Машина $mark $color $number"
    }

    override fun hashCode(): Int {
        var result = mark.hashCode()
        result = 31 * result + color.hashCode()
        result = 31 * result + number.hashCode()
        result = 31 * result + ownerName.hashCode()
        result = 31 * result + owner.hashCode()
        return result
    }
}
