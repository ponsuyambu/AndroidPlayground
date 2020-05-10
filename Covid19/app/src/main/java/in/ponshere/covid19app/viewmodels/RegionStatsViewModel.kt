package `in`.ponshere.covid19app.viewmodels

import `in`.ponshere.covid19app.network.ServiceHelper
import `in`.ponshere.covid19app.network.responses.CountriesStatsResponse
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RegionStatsViewModel : ViewModel() {

    private val countryStats = MutableLiveData<CountriesStatsResponse>()
    private val showLoading = MutableLiveData<Boolean>()

    fun fetchGeneralStats() {
        viewModelScope.launch {
            showLoading.postValue(true)
            val result = ServiceHelper.getGeneralStatsService().getCountryStats()
            countryStats.postValue(result.body())
            showLoading.postValue(false)
        }
    }

    fun countryStats(): LiveData<CountriesStatsResponse> = countryStats

    fun showLoading(): LiveData<Boolean> = showLoading
}