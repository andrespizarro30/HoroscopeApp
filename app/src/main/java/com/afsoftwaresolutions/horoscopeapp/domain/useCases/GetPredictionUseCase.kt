package com.afsoftwaresolutions.horoscopeapp.domain.useCases

import com.afsoftwaresolutions.horoscopeapp.domain.Repository
import javax.inject.Inject


class GetPredictionUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(sign:String) = repository.getPrediction(sign)

}