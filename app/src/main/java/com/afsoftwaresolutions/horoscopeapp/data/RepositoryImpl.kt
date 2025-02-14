package com.afsoftwaresolutions.horoscopeapp.data

import android.util.Log
import com.afsoftwaresolutions.horoscopeapp.data.network.HoroscopeApiService
import com.afsoftwaresolutions.horoscopeapp.data.network.response.PredictionResponse
import com.afsoftwaresolutions.horoscopeapp.domain.Repository
import com.afsoftwaresolutions.horoscopeapp.domain.model.PredictionModel
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService)  : Repository {

    override suspend fun getPrediction(sign: String) : PredictionModel? {
        val response = runCatching {apiService.getHoroscope(sign)}
            .onSuccess { return it.toDomain()}
            .onFailure { Log.i("AF SOFT", "Ocurrio un error ${it.message}") }
        return null
    }


}