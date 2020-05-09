package `in`.ponshere.covid19app.viewmodels

import `in`.ponshere.covid19app.network.RetrofitService
import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TotalStatsViewModel : ViewModel() {

    fun makeNetworkRequest() {
        CoroutineScope(IO).launch {
            val result = RetrofitService.getGeneralStatsService().getGeneralStats()
            val response = result.execute()
            Log.d("Network", response.body().toString())
        }
    }

    private suspend fun asyncNetworkRequest(): String {
        delay(10000)
        return "Hello"
    }
}