package com.example.ejercicio5listeners

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
//databinding
import com.example.ejercicio5listeners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.edit1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.edit2.isEnabled = binding.edit1.text.toString().isNotEmpty()
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
        binding.edit2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.boton1.isEnabled = binding.edit1.text.isNotEmpty() && binding.edit2.text.isNotEmpty()
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })

        binding.boton1.setOnClickListener {
            binding.edit1.text = binding.edit1.text.append(binding.edit2.text)
            binding.textView.text = binding.boton1.tag.toString()
            binding.edit2.text.clear()
            binding.edit2.isEnabled = false
        }

        binding.edit1.setOnFocusChangeListener{ _,hasFocus ->
            if (hasFocus) {
                binding.textView.text= binding.edit1.tag.toString()
            }
        }

        binding.edit2.setOnFocusChangeListener{ _,hasFocus ->
            if (hasFocus) {
                binding.textView.text= binding.edit2.tag.toString()
            }
        }













    }
}