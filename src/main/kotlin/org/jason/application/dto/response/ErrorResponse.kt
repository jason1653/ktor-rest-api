package org.jason.application.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val code: Int,
    val status: String,
    val message: String,
)
