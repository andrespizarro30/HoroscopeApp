package com.afsoftwaresolutions.horoscopeapp.ui.horoscope

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.afsoftwaresolutions.horoscopeapp.R
import com.afsoftwaresolutions.horoscopeapp.databinding.FragmentHoroscopeBinding
import com.afsoftwaresolutions.horoscopeapp.domain.model.HoroscopeInfo
import com.afsoftwaresolutions.horoscopeapp.domain.model.HoroscopeInfo.*
import com.afsoftwaresolutions.horoscopeapp.domain.model.HoroscopeModel
import com.afsoftwaresolutions.horoscopeapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()

    private lateinit var horoscopeAdapter:HoroscopeAdapter

    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI(){
        initList()
        initUIState()
    }

    private fun initList(){
        horoscopeAdapter = HoroscopeAdapter(
            onItemSelected = {
                val type = when(it){
                    Aries -> HoroscopeModel.Aries
                    Taurus -> HoroscopeModel.Taurus
                    Gemini -> HoroscopeModel.Gemini
                    Cancer -> HoroscopeModel.Cancer
                    Leo -> HoroscopeModel.Leo
                    Virgo -> HoroscopeModel.Virgo
                    Libra -> HoroscopeModel.Libra
                    Scorpio -> HoroscopeModel.Scorpio
                    Sagittarius -> HoroscopeModel.Sagittarius
                    Aquarius -> HoroscopeModel.Aquarius
                    Capricorn -> HoroscopeModel.Capricorn
                    Pisces -> HoroscopeModel.Pisces
                }

                findNavController().navigate(
                    HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(type)
                )
            }
        )
        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter=horoscopeAdapter
        }
    }

    private fun initUIState(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeViewModel.horoscope.collect{
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}