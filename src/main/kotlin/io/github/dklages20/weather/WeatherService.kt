package io.github.dklages20.weather

import io.github.dklages20.weather.types.Weather
import io.github.dklages20.weather.types.WeatherUnit

interface WeatherService {
    fun getCurrentWeather(
        latitude: Double,
        longitude: Double,
        unit: WeatherUnit,
    ): Weather

    fun getCurrentWeather(
        city: String,
        stateOrCountry: String,
        unit: WeatherUnit,
    ): Weather

    fun getCurrentWeatherByZipCode(
        zip: String,
        country: String,
        unit: WeatherUnit,
    ): Weather

    fun getForecast(): List<Weather>
}
