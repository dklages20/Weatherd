package io.github.dklages20.weather.openweather.types

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class OpenWeatherError(
    val message: String? = null,
)
