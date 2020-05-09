package `in`.ponshere.covid19app.fragments

import `in`.ponshere.covid19app.R
import `in`.ponshere.covid19app.network.responses.GeneralStatsResponse
import `in`.ponshere.covid19app.viewmodels.TotalStatsViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.total_stats_fragment.*

class TotalStatsFragment : Fragment() {
    private val viewModel: TotalStatsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addObservers()
        viewModel.fetchGeneralStats()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.total_stats_fragment, container, false)
    }

    private fun addObservers() {
        viewModel.generalStats().observe(this,
            Observer<GeneralStatsResponse> {
                it?.let {
                    tvOverallCases.text = it.data.totalCases
                    val lastUpdatedTime = "Last updated: ${it.data.lastUpdatedTime}"
                    tvLastUpdated.text = lastUpdatedTime
                    Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
                }
            })
    }

}