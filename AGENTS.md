# Testing Conventions

* Organize controller tests into `@Nested` inner classes by endpoint/function. 
    * For example, use `CurrentWeatherTests` for `/v1/weather/current` and `ForecastTests` for `/v1/weather/forecast`.
