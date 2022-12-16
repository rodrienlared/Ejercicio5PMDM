package com.example.ejercicio5

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import com.example.ejercicio5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var primerEditTextValido = false
        var segundoEditTextValido = false
        binding.texto1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                primerEditTextValido = binding.texto1.text.toString().isNotEmpty()
                binding.aplicarCambios.isEnabled = primerEditTextValido && segundoEditTextValido
            }
        })

        binding.texto2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                segundoEditTextValido = binding.texto2.text.toString().isNotEmpty()
                binding.aplicarCambios.isEnabled = primerEditTextValido && segundoEditTextValido
            }
        })

        binding.aplicarCambios.setOnClickListener {
            if (binding.aplicarCambios.isEnabled) {
                val primerTexto = binding.texto1.text.toString()
                val segundoTexto = binding.texto2.text.toString()

                binding.texto1.setText(primerTexto + segundoTexto)
                binding.texto2.setText("")
                binding.aplicarCambios.isEnabled = false
            }
        }

        binding.texto1.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus)
                binding.tagTV.text = "Primer EditText"
        }

        binding.texto2.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus)
                binding.tagTV.text = "Segundo EditText"
        }


    }
}