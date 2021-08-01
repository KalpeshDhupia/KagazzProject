package com.example.kagazproject

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PERMISSION_GRANTED //checking permission of camera is granted or not
        ) {
            btnTakeImage.setOnClickListener {
                val intent = Intent(this, CameraActivity::class.java)
                startActivity(intent)

            }

        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 0)
        }



        btnPreviewImage.setOnClickListener {
            val intent = Intent(this, PreviewActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PERMISSION_GRANTED
        ) {

        } else {
            Toast.makeText(this, "Please accept Camera Permission", Toast.LENGTH_SHORT)
                .show() //asking for permission if not granted
        }
    }


}