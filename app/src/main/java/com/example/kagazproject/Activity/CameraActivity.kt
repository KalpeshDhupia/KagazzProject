package com.example.kagazproject.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import com.example.kagazproject.R
import kotlinx.android.synthetic.main.activity_camera.*
import java.io.File

class CameraActivity : AppCompatActivity() {
    var camera: Camera? = null
    var preview: Preview? = null
    var imageCapture: ImageCapture? = null
    var cameraSelector: CameraSelector? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        startCamera()
        btnCapture.setOnClickListener {
            takePhoto()
        }
    }

    private fun startCamera() {
        // to start the camera

        val cameraProviderF = ProcessCameraProvider.getInstance(this)
        cameraProviderF.addListener(Runnable {
            val cameraProvider = cameraProviderF.get()
            preview = Preview.Builder().build()
            preview?.setSurfaceProvider(cameraView.createSurfaceProvider(camera?.cameraInfo))
            imageCapture = ImageCapture.Builder().build()
            cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            cameraProvider.unbindAll()
            camera = cameraProvider.bindToLifecycle(this, cameraSelector!!, preview, imageCapture)
        }, ContextCompat.getMainExecutor(this))

    }

    private fun takePhoto() {
        // to capture image and save

        val photoFile =
            File(externalMediaDirs.firstOrNull(), "KamApp - ${System.currentTimeMillis()}.jpg")
        val output = ImageCapture.OutputFileOptions.Builder(photoFile).build()
        imageCapture?.takePicture(
            output,
            ContextCompat.getMainExecutor(this),
            object : ImageCapture.OnImageSavedCallback {
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    Toast.makeText(applicationContext, "img save", Toast.LENGTH_SHORT).show()
                }

                override fun onError(exception: ImageCaptureException) {
                    TODO("Not yet implemented")
                }
            })

    }
}