package org.jason.application.dto

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val code: Int,
    val status: String,
    val message: String,
)
