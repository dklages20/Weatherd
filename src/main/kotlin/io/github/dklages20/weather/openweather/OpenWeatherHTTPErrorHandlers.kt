package io.github.dklages20.weather.openweather

import io.github.dklages20.WeatherServiceException
import io.github.dklages20.weather.openweather.types.OpenWeatherError
import org.springframework.http.HttpRequest
import org.springframework.http.HttpStatus
import org.springframework.http.client.ClientHttpResponse
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import tools.jackson.databind.json.JsonMapper

@Component
class OpenWeatherHTTPErrorHandlers(
    private val jsonMapper: JsonMapper,
) {
    fun forCoordinate(
        latitude: Double,
        longitude: Double,
    ): RestClient.ResponseSpec.ErrorHandler =
        { _: HttpRequest, response: ClientHttpResponse ->
            val error = jsonMapper.readValue(response.body, OpenWeatherError::class.java)
            val message = error.message ?: response.statusText

            if (response.statusCode == HttpStatus.NOT_FOUND) {
                throw OpenWeatherNotFoundException("Unable to find current weather for $latitude:$longitude; $message")
            }

            throw WeatherServiceException("OpenWeather returned ${response.statusCode.value()} for $latitude:$longitude; $message")
        }

    fun forLocation(
        city: String,
        stateOrCountry: String,
    ): RestClient.ResponseSpec.ErrorHandler =
        { _: HttpRequest, response: ClientHttpResponse ->
            val error = jsonMapper.readValue(response.body, OpenWeatherError::class.java)
            val message = error.message ?: response.statusText

            if (response.statusCode == HttpStatus.NOT_FOUND) {
                throw OpenWeatherNotFoundException("Unable to find current weather for $city/$stateOrCountry; $message")
            }

            throw WeatherServiceException("OpenWeather returned ${response.statusCode.value()} for $city/$stateOrCountry; $message")
        }
}
