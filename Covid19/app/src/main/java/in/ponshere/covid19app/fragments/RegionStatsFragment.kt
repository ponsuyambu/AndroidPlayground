package `in`.ponshere.covid19app.fragments

import `in`.ponshere.covid19app.R
import `in`.ponshere.covid19app.adapters.StatsAdapter
import `in`.ponshere.covid19app.network.responses.CountriesStatsResponse
import `in`.ponshere.covid19app.viewmodels.RegionStatsViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.total_stats_fragment.*

class RegionStatsFragment : Fragment() {
    private val viewModel: RegionStatsViewModel by viewModels()
    private lateinit var statsAdapter: StatsAdapter

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
        return inflater.inflate(R.layout.region_stats_fragment, container, false)
    }

    private fun addObservers() {
        viewModel.countryStats().observe(this,
            Observer<CountriesStatsResponse> {

            })
        viewModel.showLoading().observe(this, Observer {
            if (it) {
                progressBar.visibility = View.VISIBLE
            } else
                progressBar.visibility = View.GONE
        })
    }
}