package io.github.dklages20.weather.openweather

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient

@Configuration
class OpenWeatherConfig {
    @Bean
    fun openWeatherClient(openWeatherProperties: OpenWeatherProperties): RestClient {
        val builder = RestClient.builder()
        builder.baseUrl(openWeatherProperties.baseUrl)
        return builder.build()
    }
}
