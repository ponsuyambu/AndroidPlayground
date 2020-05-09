package `in`.ponshere.covid19app.viewmodels

import `in`.ponshere.covid19app.network.RetrofitService
import `in`.ponshere.covid19app.network.responses.GeneralStatsResponse
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TotalStatsViewModel : ViewModel() {

    private val generalStats = MutableLiveData<GeneralStatsResponse>()

    fun fetchGeneralStats() {
        CoroutineScope(IO).launch {
            val result = RetrofitService.getGeneralStatsService().getGeneralStats().execute()
            generalStats.postValue(result.body())
            Log.d("Network", result.body().toString())
        }
    }

    fun generalStats(): LiveData<GeneralStatsResponse> = generalStats
}