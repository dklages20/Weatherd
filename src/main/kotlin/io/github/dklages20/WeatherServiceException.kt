package io.github.dklages20

open class WeatherServiceException(
    message: String,
    cause: Throwable? = null,
) : Exception(message, cause)
