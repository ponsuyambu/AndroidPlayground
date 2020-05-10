package `in`.ponshere.covid19app.network.responses

import com.google.gson.annotations.SerializedName

class CountriesStatsResponse(private val data: Data, val status: String) {
    val countriesStats: ArrayList<CountryStats> = data.rows

    class Data {
        @SerializedName("last_update")
        val lastUpdatedTime: String? = null

        val rows: ArrayList<CountryStats> = arrayListOf()
    }

    class CountryStats {
        @SerializedName("country")
        private val name: String? = null

        @SerializedName("country_abbreviation")
        private val abbreviation: String? = null

        @SerializedName("total_cases")
        private val totalCases: String? = null

        @SerializedName("new_cases")
        private val newCases: String? = null

        @SerializedName("total_deaths")
        private val totalDeaths: String? = null

        @SerializedName("new_deaths")
        private val newDeaths: String? = null

        @SerializedName("total_recovered")
        private val totalRecovered: String? = null

        @SerializedName("active_cases")
        private val activeCases: String? = null

        private val flag: String? = null
    }
}