package com.example.cadastrolivros

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        // chaves usadas para transportar os dados entre as telas
        const val EXTRA_TITULO = "extra_titulo"
        const val EXTRA_AUTOR = "extra_autor"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTitulo = findViewById<EditText>(R.id.etTitulo)
        val etAutor = findViewById<EditText>(R.id.etAutor)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)

        btnCadastrar.setOnClickListener {
            val titulo = etTitulo.text.toString().trim()
            val autor = etAutor.text.toString().trim()

            when {
                titulo.isEmpty() -> {
                    etTitulo.error = "Informe o título"
                    etTitulo.requestFocus()
                }

                autor.isEmpty() -> {
                    etAutor.error = "Informe o autor"
                    etAutor.requestFocus()
                }

                else -> {
                    // Intent explícita: abre a segunda tela levando os dados
                    val intent = Intent(this, DetalhesActivity::class.java).apply {
                        putExtra(EXTRA_TITULO, titulo)
                        putExtra(EXTRA_AUTOR, autor)
                    }
                    startActivity(intent)

                    Toast.makeText(this, "Livro cadastrado!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
