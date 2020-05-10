package `in`.ponshere.covid19app.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ServiceHelper {
    private val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("https://corona-virus-stats.herokuapp.com")
            .client(buildClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.SECONDS)
            .readTimeout(2, TimeUnit.SECONDS)
            .addInterceptor(interceptor).build()
    }

    fun getGeneralStatsService(): Covid19TrackerService {
        return retrofit.create(Covid19TrackerService::class.java)
    }
}