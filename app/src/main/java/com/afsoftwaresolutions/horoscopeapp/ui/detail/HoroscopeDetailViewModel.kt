package com.afsoftwaresolutions.horoscopeapp.ui.detail

import androidx.lifecycle.ViewModel
import com.afsoftwaresolutions.horoscopeapp.data.providers.HoroscopeProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor():ViewModel(){

    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state:StateFlow<HoroscopeDetailState> = _state



}