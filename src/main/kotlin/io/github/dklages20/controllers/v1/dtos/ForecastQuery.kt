package io.github.dklages20.controllers.v1.dtos

import io.github.dklages20.weather.WeatherLanguage
import io.github.dklages20.weather.WeatherUnit
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

data class ForecastQuery(
    @param:DecimalMin("-90.0")
    @param:DecimalMax("90.0")
    val latitude: Double,
    @param:DecimalMin("-180.0")
    @param:DecimalMax("180.0")
    val longitude: Double,
    val unit: WeatherUnit,
    val language: WeatherLanguage,
    @param:Max(5)
    @param:Min(1)
    val days: Int,
)
