package io.github.dklages20.weather.types

import com.fasterxml.jackson.annotation.JsonInclude
import io.github.dklages20.weather.openweather.types.CurrentWeather

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Weather(
    val pressure: Double,
    val humidity: Double,
    val visibility: Double,
    val conditions: List<WeatherCondition>,
    val temperature: TemperatureConditions,
    val wind: WindConditions? = null,
    val cloudiness: CloudinessConditions? = null,
    val precipitation: List<PrecipitationConditions>,
) {
    constructor(currentWeather: CurrentWeather) : this(
        pressure = currentWeather.main.pressure,
        humidity = currentWeather.main.humidity,
        visibility = currentWeather.visibility,
        temperature = TemperatureConditions(currentWeather.main),
        wind = currentWeather.wind?.let(::WindConditions),
        cloudiness = currentWeather.clouds?.let(::CloudinessConditions),
        conditions = currentWeather.weather.map { WeatherCondition.valueOf(it.main.uppercase()) },
        precipitation =
            listOfNotNull(
                currentWeather.rain?.let { PrecipitationConditions(it.nextHour, PrecipitationConditions.PrecipitationType.RAIN) },
                currentWeather.snow?.let { PrecipitationConditions(it.nextHour, PrecipitationConditions.PrecipitationType.SNOW) },
            ),
    )

    enum class WeatherCondition {
        THUNDERSTORM,
        DRIZZLE,
        RAIN,
        SNOW,
        MIST,
        SMOKE,
        HAZE,
        DUST,
        FOG,
        SAND,
        ASH,
        SQUALL,
        TORNADO,
        CLEAR,
        CLOUDS,
    }
}
