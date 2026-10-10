package io.github.dklages20.weather.types

import io.github.dklages20.weather.openweather.types.CurrentWeather

data class WindConditions(
    val speed: Double,
    val degrees: Double,
    val gusts: Double?,
) {
    constructor(currentWindConditions: CurrentWeather.WindCondition) : this(
        speed = currentWindConditions.speed,
        degrees = currentWindConditions.deg,
        gusts = currentWindConditions.gust,
    )
}
