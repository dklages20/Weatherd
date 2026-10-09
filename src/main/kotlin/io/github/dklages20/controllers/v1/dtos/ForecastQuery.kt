package io.github.dklages20.controllers.v1.dtos

import io.github.dklages20.weather.WeatherLanguage
import io.github.dklages20.weather.WeatherUnit
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

data class ForecastQuery(
    @field:DecimalMin("-90.0")
    @field:DecimalMax("90.0")
    val latitude: Double,
    @field:DecimalMin("-180.0")
    @field:DecimalMax("180.0")
    val longitude: Double,
    val unit: WeatherUnit,
    val language: WeatherLanguage,
    @field:Max(5)
    @field:Min(1)
    val days: Int,
)
