package io.github.dklages20.controllers.v1

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
class WeatherControllerV1Test {
    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext

    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    }

    @Nested
    inner class CurrentWeatherTests {
        @Test
        fun `without latitude returns bad request`() {
            mockMvc
                .get("/v1/weather/current") {
                    param("longitude", "-122.4194")
                    param("language", "EN")
                    param("unit", "METRIC")
                }.andExpect {
                    status { isBadRequest() }
                }
        }

        @Test
        fun `without longitude returns bad request`() {
            mockMvc
                .get("/v1/weather/current") {
                    param("latitude", "37.7749")
                    param("language", "EN")
                    param("unit", "METRIC")
                }.andExpect {
                    status { isBadRequest() }
                }
        }

        @Test
        fun `without language returns bad request`() {
            mockMvc
                .get("/v1/weather/current") {
                    param("latitude", "37.7749")
                    param("longitude", "-122.4194")
                    param("unit", "METRIC")
                }.andExpect {
                    status { isBadRequest() }
                }
        }

        @Test
        fun `without unit returns bad request`() {
            mockMvc
                .get("/v1/weather/current") {
                    param("latitude", "37.7749")
                    param("longitude", "-122.4194")
                    param("language", "EN")
                }.andExpect {
                    status { isBadRequest() }
                }
        }

        @Test
        fun `with all parameters returns ok`() {
            mockMvc
                .get("/v1/weather/current") {
                    param("latitude", "37.7749")
                    param("longitude", "-122.4194")
                    param("language", "EN")
                    param("unit", "METRIC")
                }.andExpect {
                    status { isOk() }
                }
        }

        @Test
        fun `with latitude below negative ninety returns bad request`() {
            mockMvc
                .get("/v1/weather/current") {
                    param("latitude", "-90.1")
                    param("longitude", "-122.4194")
                    param("language", "EN")
                    param("unit", "METRIC")
                }.andExpect {
                    status { isBadRequest() }
                }
        }

        @Test
        fun `with latitude above ninety returns bad request`() {
            mockMvc
                .get("/v1/weather/current") {
                    param("latitude", "90.1")
                    param("longitude", "-122.4194")
                    param("language", "EN")
                    param("unit", "METRIC")
                }.andExpect {
                    status { isBadRequest() }
                }
        }

        @Test
        fun `with longitude below negative one hundred eighty returns bad request`() {
            mockMvc
                .get("/v1/weather/current") {
                    param("latitude", "37.7749")
                    param("longitude", "-180.1")
                    param("language", "EN")
                    param("unit", "METRIC")
                }.andExpect {
                    status { isBadRequest() }
                }
        }

        @Test
        fun `with longitude above one hundred eighty returns bad request`() {
            mockMvc
                .get("/v1/weather/current") {
                    param("latitude", "37.7749")
                    param("longitude", "180.1")
                    param("language", "EN")
                    param("unit", "METRIC")
                }.andExpect {
                    status { isBadRequest() }
                }
        }
    }

    @Nested
    inner class ForecastTests {
        @Test
        fun `without latitude returns bad request`() {
            mockMvc
                .get("/v1/weather/forecast") {
                    param("longitude", "-122.4194")
                    param("language", "EN")
                    param("unit", "METRIC")
                    param("days", "3")
                }.andExpect {
                    status { isBadRequest() }
                }
        }

        @Test
        fun `without longitude returns bad request`() {
            mockMvc
                .get("/v1/weather/forecast") {
                    param("latitude", "37.7749")
                    param("language", "EN")
                    param("unit", "METRIC")
                    param("days", "3")
                }.andExpect {
                    status { isBadRequest() }
                }
        }

        @Test
        fun `without language returns bad request`() {
            mockMvc
                .get("/v1/weather/forecast") {
                    param("latitude", "37.7749")
                    param("longitude", "-122.4194")
                    param("unit", "METRIC")
                    param("days", "3")
                }.andExpect {
                    status { isBadRequest() }
                }
        }

        @Test
        fun `without unit returns bad request`() {
            mockMvc
                .get("/v1/weather/forecast") {
                    param("latitude", "37.7749")
                    param("longitude", "-122.4194")
                    param("language", "EN")
                    param("days", "3")
                }.andExpect {
                    status { isBadRequest() }
                }
        }

        @Test
        fun `without days returns bad request`() {
            mockMvc
                .get("/v1/weather/forecast") {
                    param("latitude", "37.7749")
                    param("longitude", "-122.4194")
                    param("language", "EN")
                    param("unit", "METRIC")
                }.andExpect {
                    status { isBadRequest() }
                }
        }

        @Test
        fun `with all parameters returns ok`() {
            mockMvc
                .get("/v1/weather/forecast") {
                    param("latitude", "37.7749")
                    param("longitude", "-122.4194")
                    param("language", "EN")
                    param("unit", "METRIC")
                    param("days", "3")
                }.andExpect {
                    status { isOk() }
                }
        }

        @Test
        fun `with latitude below negative ninety returns bad request`() {
            mockMvc
                .get("/v1/weather/forecast") {
                    param("latitude", "-90.1")
                    param("longitude", "-122.4194")
                    param("language", "EN")
                    param("unit", "METRIC")
                    param("days", "3")
                }.andExpect {
                    status { isBadRequest() }
                }
        }

        @Test
        fun `with latitude above ninety returns bad request`() {
            mockMvc
                .get("/v1/weather/forecast") {
                    param("latitude", "90.1")
                    param("longitude", "-122.4194")
                    param("language", "EN")
                    param("unit", "METRIC")
                    param("days", "3")
                }.andExpect {
                    status { isBadRequest() }
                }
        }

        @Test
        fun `with longitude below negative one hundred eighty returns bad request`() {
            mockMvc
                .get("/v1/weather/forecast") {
                    param("latitude", "37.7749")
                    param("longitude", "-180.1")
                    param("language", "EN")
                    param("unit", "METRIC")
                    param("days", "3")
                }.andExpect {
                    status { isBadRequest() }
                }
        }

        @Test
        fun `with longitude above one hundred eighty returns bad request`() {
            mockMvc
                .get("/v1/weather/forecast") {
                    param("latitude", "37.7749")
                    param("longitude", "180.1")
                    param("language", "EN")
                    param("unit", "METRIC")
                    param("days", "3")
                }.andExpect {
                    status { isBadRequest() }
                }
        }

        @Test
        fun `with days below one returns bad request`() {
            mockMvc
                .get("/v1/weather/forecast") {
                    param("latitude", "37.7749")
                    param("longitude", "-122.4194")
                    param("language", "EN")
                    param("unit", "METRIC")
                    param("days", "0")
                }.andExpect {
                    status { isBadRequest() }
                }
        }

        @Test
        fun `with days above five returns bad request`() {
            mockMvc
                .get("/v1/weather/forecast") {
                    param("latitude", "37.7749")
                    param("longitude", "-122.4194")
                    param("language", "EN")
                    param("unit", "METRIC")
                    param("days", "6")
                }.andExpect {
                    status { isBadRequest() }
                }
        }
    }
}
