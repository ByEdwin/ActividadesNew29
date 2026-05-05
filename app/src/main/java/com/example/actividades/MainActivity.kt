package com.example.actividades

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.actividades.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSend.setOnClickListener {

            val miHeroe = Heroe(
                nombre = "Mark",
                nivel = 1,
                vida = 100
            )

            val intent = Intent(this, SecondaryActivity::class.java).apply {
                putExtra("USER_NAME", binding.txtName.text.toString())
                putExtra("USER_AGE", 20)
                putExtra("IS_STUDENT", true)
                putExtra("USER_HEROE", miHeroe)
            }

            startActivity(intent)
        }
    }
}