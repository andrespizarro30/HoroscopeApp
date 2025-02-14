package com.afsoftwaresolutions.horoscopeapp.domain

import com.afsoftwaresolutions.horoscopeapp.data.network.response.PredictionResponse
import com.afsoftwaresolutions.horoscopeapp.domain.model.PredictionModel

interface Repository {

    suspend fun getPrediction(sign:String) : PredictionModel?

}