package io.github.dklages20.weather.openweather

import io.github.dklages20.WeatherServiceException
import io.github.dklages20.weather.WeatherService
import io.github.dklages20.weather.openweather.types.CurrentWeather
import io.github.dklages20.weather.types.Weather
import io.github.dklages20.weather.types.WeatherUnit
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
@ConditionalOnProperty(prefix = "open.weather", name = ["enabled"], havingValue = "true", matchIfMissing = false)
class OpenWeatherAdapter(
    private val openWeatherProperties: OpenWeatherProperties,
    private val openWeatherClient: RestClient,
    private val openWeatherHTTPErrorHandlers: OpenWeatherHTTPErrorHandlers,
) : WeatherService {
    override fun getCurrentWeather(
        latitude: Double,
        longitude: Double,
        unit: WeatherUnit,
    ): Weather {
        val currentWeather =
            openWeatherClient
                .get()
                .uri { uriBuilder ->
                    uriBuilder.path("/weather")
                    uriBuilder.queryParam(QUERY_PARAM_LATITUDE, latitude)
                    uriBuilder.queryParam(QUERY_PARAM_LONGITUDE, longitude)
                    uriBuilder.queryParam(QUERY_PARAM_API_KEY, openWeatherProperties.apiKey)
                    uriBuilder.queryParam(QUERY_PARAM_UNITS, unit)
                    uriBuilder.build()
                }.retrieve()
                .onStatus(HttpStatusCode::isError, openWeatherHTTPErrorHandlers.forCoordinate(latitude, longitude))
                .body(CurrentWeather::class.java)

        return Weather(
            currentWeather ?: throw WeatherServiceException("OpenWeather returned an empty response for coordinate: $latitude:$longitude"),
        )
    }

    override fun getCurrentWeather(
        city: String,
        stateOrCountry: String,
        unit: WeatherUnit,
    ): Weather {
        val currentWeather =
            openWeatherClient
                .get()
                .uri { uriBuilder ->
                    uriBuilder.path("/weather")
                    uriBuilder.queryParam(QUERY_PARAM_Q, "$city,$stateOrCountry")
                    uriBuilder.queryParam(QUERY_PARAM_API_KEY, openWeatherProperties.apiKey)
                    uriBuilder.queryParam(QUERY_PARAM_UNITS, unit)
                    uriBuilder.build()
                }.retrieve()
                .onStatus(HttpStatusCode::isError, openWeatherHTTPErrorHandlers.forLocation(city, stateOrCountry))
                .body(CurrentWeather::class.java)

        return Weather(
            currentWeather ?: throw WeatherServiceException("OpenWeather returned an empty response for location: $city/$stateOrCountry"),
        )
    }

    override fun getCurrentWeatherByZipCode(
        zip: String,
        country: String,
        unit: WeatherUnit,
    ): Weather {
        val currentWeather =
            openWeatherClient
                .get()
                .uri { uriBuilder ->
                    uriBuilder.path("/weather")
                    uriBuilder.queryParam(QUERY_PARAM_ZIP, "$zip,$country")
                    uriBuilder.queryParam(QUERY_PARAM_API_KEY, openWeatherProperties.apiKey)
                    uriBuilder.queryParam(QUERY_PARAM_UNITS, unit)
                    uriBuilder.build()
                }.retrieve()
                .onStatus(HttpStatusCode::isError, openWeatherHTTPErrorHandlers.forLocation(zip, country))
                .body(CurrentWeather::class.java)

        return Weather(
            currentWeather ?: throw WeatherServiceException("OpenWeather returned an empty response for ZIP code: $zip/$country"),
        )
    }

    override fun getForecast(): List<Weather> {
        TODO("Not yet implemented")
    }

    companion object {
        private const val QUERY_PARAM_LATITUDE = "lat"
        private const val QUERY_PARAM_LONGITUDE = "lon"
        private const val QUERY_PARAM_API_KEY = "appid"
        private const val QUERY_PARAM_UNITS = "units"
        private const val QUERY_PARAM_Q = "q"
        private const val QUERY_PARAM_ZIP = "zip"
    }
}
