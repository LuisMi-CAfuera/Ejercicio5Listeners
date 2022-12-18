package com.example.ejercicio5listeners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
//databinding
import com.example.ejercicio5listeners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Edit1.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
               binding.Edit2.text = binding.Edit1.text
                binding.Boton1.isEnabled = true
            }
        }








    }
}