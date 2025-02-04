package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val tdPeso = findViewById<TextInputEditText>(R.id.td_peso)
    val tdAltura = findViewById<TextInputEditText>(R.id.td_altura)

    val btCalcular = findViewById<Button>(R.id.bt_calcular)

    btCalcular.setOnClickListener {
        val peso: String = tdPeso.text.toString()
        val altura: String = tdAltura.text.toString()

        if(peso == "" || altura == ""){
            Snackbar.make(
                tdPeso,
                "Preencha todos os campos",
                Snackbar.LENGTH_LONG,
            )
                .show()
        }else{
            val pesoDouble: Double = peso.toDouble()
            val alturaDouble: Double = altura.toDouble()

            val alturaQ2: Double = alturaDouble* alturaDouble
            val IMC = pesoDouble / alturaQ2
            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra(KEY_RESULT_IMC, IMC)
            startActivity(intent)
        }
    }
    }
}
