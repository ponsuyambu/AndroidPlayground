package `in`.ponshere.covid19app.fragments

import `in`.ponshere.covid19app.R
import `in`.ponshere.covid19app.viewmodels.TotalStatsViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class TotalStatsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model: TotalStatsViewModel by viewModels()
        model.makeNetworkRequest()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.total_stats_fragment, container, false)
    }
}