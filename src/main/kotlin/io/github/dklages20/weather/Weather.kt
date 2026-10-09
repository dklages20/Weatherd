package io.github.dklages20.weather

data class Weather(
    val pressure: Double,
    val humidity: Double,
    val visibility: Double,
    val temperature: TemperatureConditions,
    val wind: WindConditions? = null,
    val cloudiness: CloudinessConditions? = null,
    val precipitation: PrecipitationConditions? = null,
    val conditions: List<WeatherCondition> = emptyList(),
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
