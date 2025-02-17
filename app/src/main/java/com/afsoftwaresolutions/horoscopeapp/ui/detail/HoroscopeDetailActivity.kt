package com.afsoftwaresolutions.horoscopeapp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.afsoftwaresolutions.horoscopeapp.R
import com.afsoftwaresolutions.horoscopeapp.databinding.ActivityHoroscopeDetailBinding
import com.afsoftwaresolutions.horoscopeapp.domain.model.HoroscopeModel
import com.afsoftwaresolutions.horoscopeapp.domain.model.HoroscopeModel.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel by viewModels<HoroscopeDetailViewModel>()

    private val args:HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initUI()

        horoscopeDetailViewModel.getHoroscope(args.type)

    }

    private fun initUI(){
        initListeners()
        initUIState()
    }

    private fun initListeners(){
        binding.ivDetail.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initUIState(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeDetailViewModel.state.collect{
                    when(it){
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun loadingState(){
        binding.pb.isVisible = true
    }

    private fun errorState(){
        binding.pb.isVisible = false
    }

    private fun successState(state: HoroscopeDetailState.Success){
        binding.pb.isVisible = false
        binding.tvTitle.text = state.predictionModel.sign
        binding.tvBody.text = state.predictionModel.horoscope

        val image = when (state.horoscopeModel) {
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }

        binding.ivDetail.setImageResource(image)
    }

}