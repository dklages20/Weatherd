package io.github.dklages20.weather.types

data class PrecipitationConditions(
    val nextHour: Double,
    val type: PrecipitationType,
) {
    enum class PrecipitationType {
        RAIN,
        SNOW,
        MIX,
    }
}
