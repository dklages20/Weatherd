package io.github.dklages20.weather.openweather

import io.github.dklages20.WeatherServiceException

class OpenWeatherNotFoundException(
    message: String,
) : WeatherServiceException(message)
