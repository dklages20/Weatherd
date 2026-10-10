package io.github.dklages20.weather.openweather

import jakarta.validation.constraints.NotBlank
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated

@Validated
@ConfigurationProperties("open.weather")
data class OpenWeatherProperties(
    val enabled: Boolean,
    @field:NotBlank
    val apiKey: String,
    @field:NotBlank
    val baseUrl: String,
)
