package com.afsoftwaresolutions.horoscopeapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.afsoftwaresolutions.horoscopeapp.data.providers.HoroscopeProvider
import com.afsoftwaresolutions.horoscopeapp.domain.model.HoroscopeInfo
import com.afsoftwaresolutions.horoscopeapp.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(private val horoscopeProvider: HoroscopeProvider):ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope:StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        _horoscope.value = horoscopeProvider.getHoroscopes()
    }

}