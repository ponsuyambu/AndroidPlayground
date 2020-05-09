package `in`.ponshere.covid19app.network.responses

import com.google.gson.annotations.SerializedName

class GeneralStatsResponse(val data: Data, val status: String) {

    class Data {
        @SerializedName("total_cases")
        var totalCases: String? = null
        @SerializedName("recovery_cases")
        var recoveryCases: String? = null
        @SerializedName("death_cases")
        var deathCases: String? = null
        @SerializedName("currently_infected")
        val currentlyInfected: String? = null
        @SerializedName("last_update")
        val lastUpdatedTime: String? = ""
    }
}

