package com.afsoftwaresolutions.horoscopeapp.data.network.response

import com.afsoftwaresolutions.horoscopeapp.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName

data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("icon") val icon: String,
    @SerializedName("id") val id: Long,
    @SerializedName("sign") val sign: String
){
    fun toDomain():PredictionModel{
        return PredictionModel(
            horoscope = horoscope,
            sign = sign
        )
    }
}
