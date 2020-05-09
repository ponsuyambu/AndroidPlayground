package `in`.ponshere.covid19app.models

import androidx.annotation.DrawableRes

data class StatsModel(
    @DrawableRes val icon: Int,
    val title: String?,
    val lastUpdatedTime: String?,
    val count: String?
)