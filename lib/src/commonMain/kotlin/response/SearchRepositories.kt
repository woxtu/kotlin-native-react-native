package io.github.woxtu.overlord.response

import io.github.woxtu.overlord.entity.Repository
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchRepositories(
        @SerialName("total_count")
        val totalCount: Int,
        val items: List<Repository>
)
