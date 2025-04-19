package com.mushy.artcom_proy

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothProfile
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class APP_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app)
//val1
        val boton = findViewById<Button>(R.id.activado)
        boton.setOnClickListener {
            val audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

            // Verifica si los audífonos por cable están conectados
            val isHeadphonePlugged = audioManager.isWiredHeadsetOn

            // Verifica si hay audífonos Bluetooth conectados (en uso de audio)
            val isBluetoothConnected =
                audioManager.isBluetoothA2dpOn || audioManager.isBluetoothScoOn

            // Lógica para mostrar el mensaje
            if (isHeadphonePlugged || isBluetoothConnected) {
                Log.d("APP_Activity", "Audífonos detectados. Amplificación activada.")
                Toast.makeText(
                    this,
                    "Audífonos conectados. Amplificación activada.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Log.d("APP_Activity", "No se detectaron audífonos.")
                Toast.makeText(
                    this,
                    "Conecta tus audífonos para usar el amplificador.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

//val2
        val boton2 = findViewById<Button>(R.id.abrirpantalla)
        boton2.setOnClickListener {
            val intent = Intent(this, Screen_Activity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}