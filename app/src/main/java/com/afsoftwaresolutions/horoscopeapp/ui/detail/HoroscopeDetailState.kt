package com.afsoftwaresolutions.horoscopeapp.ui.detail

import com.afsoftwaresolutions.horoscopeapp.domain.model.HoroscopeModel
import com.afsoftwaresolutions.horoscopeapp.domain.model.PredictionModel

sealed class HoroscopeDetailState {
    data object Loading:HoroscopeDetailState()
    data class Error(val error: String):HoroscopeDetailState()
    data class Success(val predictionModel: PredictionModel, val horoscopeModel: HoroscopeModel):HoroscopeDetailState()
}