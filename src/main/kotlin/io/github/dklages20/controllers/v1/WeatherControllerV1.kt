package io.github.dklages20.controllers.v1

import io.github.dklages20.controllers.v1.dtos.CurrentWeatherQuery
import io.github.dklages20.controllers.v1.dtos.ForecastResponse
import io.github.dklages20.controllers.v1.dtos.CurrentWeatherResponse
import io.github.dklages20.controllers.v1.dtos.ForecastQuery
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/weather")
class WeatherControllerV1 {

    @GetMapping("/current")
    fun getCurrentWeather(
        currentWeatherQuery: CurrentWeatherQuery
    ): CurrentWeatherResponse {
        return CurrentWeatherResponse()
    }

    @GetMapping("/forecast")
    fun getForecast(
        forecastQuery: ForecastQuery
    ): ForecastResponse {
        return ForecastResponse()
    }
}
