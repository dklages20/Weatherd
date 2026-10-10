package io.github.dklages20.weather.types

import io.github.dklages20.weather.openweather.types.CurrentWeather

data class CloudinessConditions(
    val coverage: Double,
) {
    constructor(currentCloudCondition: CurrentWeather.CloudCondition) : this(coverage = currentCloudCondition.all)
}
