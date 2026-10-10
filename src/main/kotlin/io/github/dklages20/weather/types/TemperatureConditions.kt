package io.github.dklages20.weather.types

import io.github.dklages20.weather.openweather.types.CurrentWeather

data class TemperatureConditions(
    val temperature: Double,
    val feelsLike: Double,
    val low: Double,
    val high: Double,
) {
    constructor(currentWeatherMain: CurrentWeather.WeatherMain) : this(
        temperature = currentWeatherMain.temp,
        feelsLike = currentWeatherMain.feelsLike,
        low = currentWeatherMain.tempMin,
        high = currentWeatherMain.tempMax,
    )
}
