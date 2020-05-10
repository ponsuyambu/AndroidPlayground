package `in`.ponshere.covid19app.fragments

import `in`.ponshere.covid19app.R
import `in`.ponshere.covid19app.adapters.StatsAdapter
import `in`.ponshere.covid19app.models.StatsModel
import `in`.ponshere.covid19app.network.responses.GeneralStatsResponse
import `in`.ponshere.covid19app.viewmodels.TotalStatsViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.total_stats_fragment.*

class TotalStatsFragment : Fragment() {
    private val viewModel: TotalStatsViewModel by viewModels()
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
        return inflater.inflate(R.layout.total_stats_fragment, container, false)
    }

    private fun addObservers() {
        viewModel.generalStats().observe(this,
            Observer<GeneralStatsResponse> {
                it?.let {
                    val statsList = mutableListOf<StatsModel>()
                    statsList.add(
                        StatsModel(
                            R.drawable.ic_overall,
                            "Total Confirmed cases",
                            it.data.lastUpdatedTime,
                            it.data.totalCases
                        )
                    )
                    statsList.add(
                        StatsModel(
                            R.drawable.ic_current_infections,
                            "Currently Infected",
                            it.data.lastUpdatedTime,
                            it.data.currentlyInfected
                        )
                    )
                    statsList.add(
                        StatsModel(
                            R.drawable.ic_recovered,
                            "Recovered",
                            it.data.lastUpdatedTime,
                            it.data.recoveryCases
                        )
                    )
                    statsList.add(
                        StatsModel(
                            R.drawable.ic_deaths,
                            "Deaths",
                            it.data.lastUpdatedTime,
                            it.data.deathCases
                        )
                    )

                    statsAdapter = StatsAdapter(statsList)
                    statsRecyclerView.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = statsAdapter
                    }
                }
            })
        viewModel.showLoading().observe(this, Observer {
            if (it) {
                progressBar.visibility = View.VISIBLE
            } else
                progressBar.visibility = View.GONE
        })
    }
}