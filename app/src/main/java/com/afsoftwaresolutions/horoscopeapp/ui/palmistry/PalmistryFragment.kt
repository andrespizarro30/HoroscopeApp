package com.afsoftwaresolutions.horoscopeapp.ui.palmistry

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import com.afsoftwaresolutions.horoscopeapp.R
import com.afsoftwaresolutions.horoscopeapp.databinding.FragmentPalmistryBinding
import com.afsoftwaresolutions.horoscopeapp.ui.permissions.PermissionsHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PalmistryFragment : Fragment() {

    companion object {
        private const val CAMERA_PERMISSION = android.Manifest.permission.CAMERA
    }

    private var _binding:FragmentPalmistryBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var permissionsHelper: PermissionsHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (permissionsHelper.checkCameraPermission()) {
            startCamera()
        } else {
            requestPermissionLauncher.launch(CAMERA_PERMISSION)
        }

    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            startCamera()
        } else {
            Toast.makeText(
                requireContext(),
                "Se requiere aceptar permisos para poder acceder al servicio",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

        cameraProviderFuture.addListener({
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(binding.viewFinder.surfaceProvider)
                }

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try{
                cameraProvider.unbindAll()

                cameraProvider.bindToLifecycle(this, cameraSelector, preview)
            }catch (e:Exception){
                Log.e("AF SOFT", "Error: ${e.message}")
            }
        }, ContextCompat.getMainExecutor(requireContext()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPalmistryBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}