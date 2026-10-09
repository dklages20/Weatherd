package io.github.dklages20.weather

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Weather(
    val pressure: Double,
    val humidity: Double,
    val visibility: Double,
    val conditions: List<WeatherCondition>,
    val temperature: TemperatureConditions,
    val wind: WindConditions? = null,
    val cloudiness: CloudinessConditions? = null,
    val precipitation: PrecipitationConditions? = null,
) {
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
        CLOUDS
    }
}
