package com.afsoftwaresolutions.horoscopeapp.data.network

import com.afsoftwaresolutions.horoscopeapp.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {

    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign:String) : PredictionResponse


}