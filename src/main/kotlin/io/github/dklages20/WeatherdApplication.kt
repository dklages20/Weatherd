package io.github.dklages20

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WeatherdApplication

fun main(args: Array<String>) {
    SpringApplication.run(WeatherdApplication::class.java, *args)
}
