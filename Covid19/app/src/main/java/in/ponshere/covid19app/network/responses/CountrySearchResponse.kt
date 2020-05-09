package `in`.ponshere.covid19app.network.responses

import com.google.gson.annotations.SerializedName

class CountrySearchResponse {
}

class CountryStats {
    val country: String? = null
    @SerializedName("country_abbreviation")
    val abbreviation: String? = null
}