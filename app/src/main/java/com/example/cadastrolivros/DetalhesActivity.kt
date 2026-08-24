package com.example.cadastrolivros

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalhesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        // habilita a seta de voltar na barra de título
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvTitulo = findViewById<TextView>(R.id.tvTitulo)
        val tvAutor = findViewById<TextView>(R.id.tvAutor)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)

        // recupera os dados enviados pela MainActivity
        val titulo = intent.getStringExtra(MainActivity.EXTRA_TITULO) ?: "(sem título)"
        val autor = intent.getStringExtra(MainActivity.EXTRA_AUTOR) ?: "(sem autor)"

        tvTitulo.text = titulo
        tvAutor.text = autor

        // finish() fecha esta tela e devolve o usuário ao formulário
        btnVoltar.setOnClickListener { finish() }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
