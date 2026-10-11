package io.github.dklages20.controllers.v1.dtos

import io.github.dklages20.weather.types.WeatherLanguage
import io.github.dklages20.weather.types.WeatherUnit
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin

data class CurrentWeatherQueryByCoordinate(
    @field:DecimalMin("-90.0")
    @field:DecimalMax("90.0")
    val latitude: Double,
    @field:DecimalMin("-180.0")
    @field:DecimalMax("180.0")
    val longitude: Double,
    val unit: WeatherUnit,
    val language: WeatherLanguage,
)

data class CurrentWeatherQueryByCityAndState(
    val city: String,
    val state: String,
    val unit: WeatherUnit,
    val language: WeatherLanguage,
)

data class CurrentWeatherQueryByCityAndCountry(
    val city: String,
    val country: String,
    val unit: WeatherUnit,
    val language: WeatherLanguage,
)

data class CurrentWeatherQueryByZipCodeAndCountry(
    val zip: String,
    val country: String,
    val unit: WeatherUnit,
    val language: WeatherLanguage,
)
