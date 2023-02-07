package parking

class Command {

    companion object {
        const val PARK = "/park"
        const val RETURN = "/return"
        const val SHOW_PLACE = "/show_place"
        const val SHOW_CAR_INFO = "/show_car"
        const val HELP = "/help"
        const val CURRENT_STAT = "/park_all_stats"
        const val STAT = "/park_stats"
        const val ERROR = "Такой команды не существует!"
    }

}