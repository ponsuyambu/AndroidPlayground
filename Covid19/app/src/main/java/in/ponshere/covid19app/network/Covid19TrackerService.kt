package `in`.ponshere.covid19app.network

import `in`.ponshere.covid19app.network.responses.CountrySearchResponse
import `in`.ponshere.covid19app.network.responses.GeneralStatsResponse
import retrofit2.Response
import retrofit2.http.GET

interface Covid19TrackerService {
    @GET("api/v1/cases/general-stats")
    suspend fun getGeneralStats(): Response<GeneralStatsResponse>

    @GET("/api/v1/cases/countries-search")
    suspend fun getCountryStats(): Response<CountrySearchResponse>
}