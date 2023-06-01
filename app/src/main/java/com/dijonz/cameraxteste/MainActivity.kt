package com.dijonz.cameraxteste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.dijonz.cameraxteste.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.internal.MainDispatcherFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btAbrirCam.setOnClickListener{

            cameraProviderResult.launch(android.Manifest.permission.CAMERA)
            abrirTelaPreview()
        }
    }

    private fun abrirTelaPreview(){
        val intent = Intent(this, CameraPreviewActivity::class.java)
        startActivity(intent)
    }

    private val cameraProviderResult =
        registerForActivityResult(ActivityResultContracts.RequestPermission()){
            if (it){
                abrirTelaPreview()
            }else{
                Snackbar.make(binding.root, "Você precisa aceitar as permissões para utilizar a câmera",
                Snackbar.LENGTH_LONG).show()
            }
    }

}