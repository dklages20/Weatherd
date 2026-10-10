package io.github.dklages20.controllers.v1

import io.github.dklages20.controllers.v1.dtos.CurrentWeatherQueryByCityAndCountry
import io.github.dklages20.controllers.v1.dtos.CurrentWeatherQueryByCityAndState
import io.github.dklages20.controllers.v1.dtos.CurrentWeatherQueryByCoordinate
import io.github.dklages20.controllers.v1.dtos.ForecastQuery
import io.github.dklages20.controllers.v1.dtos.ForecastResponse
import io.github.dklages20.weather.WeatherService
import io.github.dklages20.weather.types.Weather
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/weather")
class WeatherControllerV1(
    private val weatherService: WeatherService,
) {
    @GetMapping("/current/coordinate")
    fun getCurrentWeather(
        @Valid @ModelAttribute currentWeatherQuery: CurrentWeatherQueryByCoordinate,
    ): Weather {
        val weather =
            weatherService.getCurrentWeather(
                latitude = currentWeatherQuery.latitude,
                longitude = currentWeatherQuery.longitude,
                unit = currentWeatherQuery.unit,
            )

        return weather
    }

    @GetMapping("/current/us")
    fun getCurrentWeather(
        @Valid @ModelAttribute currentWeatherQuery: CurrentWeatherQueryByCityAndState,
    ): Weather {
        val weather =
            weatherService.getCurrentWeather(
                city = currentWeatherQuery.city,
                stateOrCountry = currentWeatherQuery.state,
                unit = currentWeatherQuery.unit,
            )

        return weather
    }

    @GetMapping("/current/global")
    fun getCurrentWeather(
        @Valid @ModelAttribute currentWeatherQuery: CurrentWeatherQueryByCityAndCountry,
    ): Weather {
        val weather =
            weatherService.getCurrentWeather(
                city = currentWeatherQuery.city,
                stateOrCountry = currentWeatherQuery.country,
                unit = currentWeatherQuery.unit,
            )

        return weather
    }

    @GetMapping("/forecast")
    fun getForecast(
        @Valid @ModelAttribute forecastQuery: ForecastQuery,
    ): ForecastResponse = ForecastResponse()
}
