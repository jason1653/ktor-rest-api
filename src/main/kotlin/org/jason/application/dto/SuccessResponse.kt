package org.jason.application.dto

import kotlinx.serialization.Serializable

@Serializable
data class SuccessResponse<T>(
    val code: Int = 200,
    val status: String = "200",
    val message: String = "OK",
    val body: T
)