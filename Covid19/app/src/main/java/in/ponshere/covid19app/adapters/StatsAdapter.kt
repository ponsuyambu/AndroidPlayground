package `in`.ponshere.covid19app.adapters

import `in`.ponshere.covid19app.R
import `in`.ponshere.covid19app.models.StatsModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StatsAdapter(private val statsList: List<StatsModel>) :
    RecyclerView.Adapter<StatsAdapter.StatsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = StatsViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.stats_layout,
            parent,
            false
        )
    )


    override fun getItemCount() = statsList.size

    override fun onBindViewHolder(holder: StatsViewHolder, position: Int) =
        holder.bind(statsList[position])

    class StatsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.tvTitle)
        private val count: TextView = view.findViewById(R.id.tvCount)
        private val lastUpdated: TextView = view.findViewById(R.id.tvLastUpdated)
        private val icon: ImageView = view.findViewById(R.id.imgIcon)

        fun bind(statsModel: StatsModel) {
            title.text = statsModel.title
            count.text = statsModel.count
            lastUpdated.text = "Last updated: ${statsModel.lastUpdatedTime}"
            icon.setImageResource(statsModel.icon)
        }
    }
}