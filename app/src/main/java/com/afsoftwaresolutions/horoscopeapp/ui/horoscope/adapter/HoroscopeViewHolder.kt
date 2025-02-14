package com.afsoftwaresolutions.horoscopeapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.afsoftwaresolutions.horoscopeapp.databinding.ItemHoroscopeBinding
import com.afsoftwaresolutions.horoscopeapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo,onItemSelected:(HoroscopeInfo)->Unit){
        val context = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = context.getString(horoscopeInfo.name)

        binding.parent.setOnClickListener {
            startRotationAnimation(binding.ivHoroscope, onItemSelected = {onItemSelected(horoscopeInfo)})
        }
    }

    private fun startRotationAnimation(view:View,onItemSelected:()->Unit){
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction{
                onItemSelected()
            }
            start()
        }
    }

}