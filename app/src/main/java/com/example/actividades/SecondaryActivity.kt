package com.example.actividades

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.actividades.databinding.ActivitySecondaryBinding

class SecondaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bundle = intent.extras

        val heroe = intent.getParcelableExtra<Heroe>("USER_HEROE")

        heroe?.let {
           // binding.txtNombre.text = it.nombre
           // binding.txtNivel.text = "Nivel: ${it.nivel}"
          //  binding.txtVida.text = "Vida: ${it.vida}"
        }

        // binding.tvwName.text= miHeroe?.nombre

        binding.tvwName.text = bundle?.getString("USER_NAME")
       binding.tvwEdad.text = bundle?.getInt("USER_AGE").toString()
      binding.tvwEstudiante.text = bundle?.getBoolean("IS_STUDENT").toString()
    }
}