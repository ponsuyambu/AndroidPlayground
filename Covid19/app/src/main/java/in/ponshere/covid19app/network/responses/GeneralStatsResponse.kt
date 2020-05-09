package `in`.ponshere.covid19app.network.responses

class GeneralStatsResponse(val data: Data, val status: String) {

    class Data {
        var total_cases: String? = null
        var recovery_cases: String? = null
        var death_cases: String? = null
    }
}

