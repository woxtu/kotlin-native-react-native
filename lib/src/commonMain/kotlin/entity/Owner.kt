package io.github.woxtu.overlord.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Owner(
        val id: Int,
        @SerialName("login")
        val name: String,
        @SerialName("avatar_url")
        val avatarUrl: String
)