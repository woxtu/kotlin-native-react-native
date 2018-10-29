package io.github.woxtu.overlord.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Repository(
        val id: Int,
        val name: String,
        val owner: Owner,
        @SerialName("html_url")
        val htmlUrl: String
)