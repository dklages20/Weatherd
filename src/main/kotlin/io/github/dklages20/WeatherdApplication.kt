package io.github.dklages20

import io.github.dklages20.weather.openweather.OpenWeatherProperties
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties

@SpringBootApplication
@EnableConfigurationProperties(OpenWeatherProperties::class)
class WeatherdApplication

fun main(args: Array<String>) {
    SpringApplication.run(WeatherdApplication::class.java, *args)
}
