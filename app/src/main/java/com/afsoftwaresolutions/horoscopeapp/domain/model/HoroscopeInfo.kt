package com.afsoftwaresolutions.horoscopeapp.domain.model

import com.afsoftwaresolutions.horoscopeapp.R

sealed class HoroscopeInfo(val img: Int,val name: Int){
    data object Aries:HoroscopeInfo(img= R.drawable.aries,name= R.string.aries)
    data object Taurus: HoroscopeInfo(img= R.drawable.tauro,name= R.string.taurus)
    data object Gemini: HoroscopeInfo(img= R.drawable.geminis,name= R.string.gemini)
    data object Cancer: HoroscopeInfo(img= R.drawable.cancer,name= R.string.cancer)
    data object Leo: HoroscopeInfo(img= R.drawable.leo,name= R.string.leo)
    data object Virgo: HoroscopeInfo(img= R.drawable.virgo,name= R.string.virgo)
    data object Libra: HoroscopeInfo(img= R.drawable.libra,name= R.string.libra)
    data object Scorpio: HoroscopeInfo(img= R.drawable.escorpio,name= R.string.scorpio)
    data object Sagittarius: HoroscopeInfo(img= R.drawable.sagitario,name= R.string.sagittarius)
    data object Capricorn: HoroscopeInfo(img= R.drawable.capricornio,name= R.string.capricorn)
    data object Aquarius: HoroscopeInfo(img= R.drawable.aquario,name= R.string.aquarius)
    data object Pisces: HoroscopeInfo(img= R.drawable.piscis,name= R.string.pisces)
}
