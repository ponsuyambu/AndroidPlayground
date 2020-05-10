package `in`.ponshere.covid19app.viewmodels

import `in`.ponshere.covid19app.network.RetrofitService
import `in`.ponshere.covid19app.network.responses.GeneralStatsResponse
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TotalStatsViewModel : ViewModel() {

    private val generalStats = MutableLiveData<GeneralStatsResponse>()
    private val showLoading = MutableLiveData<Boolean>()

    fun fetchGeneralStats() {
        viewModelScope.launch {
            showLoading.postValue(true)
            val result = RetrofitService.getGeneralStatsService().getGeneralStats()
            generalStats.postValue(result.body())
            showLoading.postValue(false)
            Log.d("Network", result.body().toString())
        }
    }

    fun generalStats(): LiveData<GeneralStatsResponse> = generalStats

    fun showLoading(): LiveData<Boolean> = showLoading
}