package `in`.ponshere.covid19app.network

import `in`.ponshere.covid19app.network.responses.CountrySearchResponse
import `in`.ponshere.covid19app.network.responses.GeneralStatsResponse
import retrofit2.Call
import retrofit2.http.GET

interface Covid19TrackerService {
    @GET("api/v1/cases/general-stats")
    fun getGeneralStats(): Call<GeneralStatsResponse>

    @GET("/api/v1/cases/countries-search")
    fun getCountryStats(): Call<CountrySearchResponse>
}