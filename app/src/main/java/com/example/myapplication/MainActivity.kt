package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rgOpcionesServicio.check(R.id.rb_servicio_malo)
        binding.rgOpcionesServicio.setOnCheckedChangeListener {_, i ->
            val cantidadInc = calcularCantidadIncrementada(binding.cuenta.toString().toDouble(),opcion)
            binding.cuentaIncrementada.text = cantidadInc.toString()
        }
        binding.botonCalcular.setOnClickListener{
            val cuentaAsString = binding.cuenta.text.toString()
            var cuenta = calcularCantidadIncrementada(binding.cuenta.text.toString().toDouble(),
            //val rbSeleccionado =
                binding.rgOpcionesServicio.checkedRadioButtonId)
            /**val incremento = when(rbSeleccionado) {
                R.id.rb_servicio_malo -> {1.0}
                R.id.rb_servicio_normal -> {1.1}
                else -> {1.2}
            }
            cuenta *= incremento**/
            cuenta /= binding.numeroPersonas.text.toString().toInt()
            val formateado = NumberFormat.getCurrencyInstance().format(cuenta)
            binding.totalPorPersona.text = getString(R.string.split_result, formateado)//cuenta.toString()
        }
        //setContentView(R.layout.activity_main)
    }

    private fun calcularCantidadIncrementada(cantidad:Double, opcion:Int):Double{
        val incremento = when(opcion) {
            R.id.rb_servicio_malo -> {
                1.0
            }

            R.id.rb_servicio_normal -> {
                1.1
            }

            else -> {
                1.2
            }
        }
        return cantidad * incremento
    }
}