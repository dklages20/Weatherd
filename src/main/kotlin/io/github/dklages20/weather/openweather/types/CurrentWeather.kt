package io.github.dklages20.weather.openweather.types

import com.fasterxml.jackson.annotation.JsonAlias
import tools.jackson.databind.PropertyNamingStrategies
import tools.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CurrentWeather(
    val coord: OpenWeatherCoordinate,
    val weather: List<WeatherCondition>,
    val base: String,
    val main: WeatherMain,
    val visibility: Double,
    val wind: WindCondition? = null,
    val clouds: CloudCondition? = null,
    val rain: RainCondition? = null,
    val snow: SnowCondition? = null,
    @param:JsonAlias("dt")
    val time: Long,
    val sys: SystemDetails,
    val timezone: Int,
    val id: Long,
    val name: String,
    val cod: Int,
) {
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class WeatherCondition(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String,
    )

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class WeatherMain(
        val temp: Double,
        val feelsLike: Double,
        val pressure: Double,
        val humidity: Double,
        val tempMin: Double,
        val tempMax: Double,
        val seaLevel: Double,
        val grndLevel: Double,
    )

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class WindCondition(
        val speed: Double,
        val deg: Double,
        val gust: Double? = null,
    )

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class CloudCondition(
        val all: Double,
    )

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class RainCondition(
        @JsonAlias("1h")
        val nextHour: Double,
    )

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class SnowCondition(
        @JsonAlias("1h")
        val nextHour: Double,
    )

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class SystemDetails(
        val type: Int,
        val id: Int,
        val country: String,
        val sunrise: Long,
        val sunset: Long,
        val message: String? = null,
    )
}
