package com.example.ac

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val heroName = intent.getStringExtra("HERO") ?: "Herói Desconhecido"

        val imgHero = findViewById<ImageView>(R.id.imgHero)
        val txtNome = findViewById<TextView>(R.id.txtHero)
        val txtMensagem = findViewById<TextView>(R.id.txtMensagem)
        val btnRetry = findViewById<Button>(R.id.btnRetry)
        val btnShare = findViewById<Button>(R.id.btnShare)

        txtNome.text = "Você é: $heroName"

        val mensagem = when (heroName) {
            "Homem de Ferro" -> "Você é brilhante, tecnológico e estratégico!"
            "Hulk" -> "Força bruta e emoção fazem parte de você."
            "Flash" -> "Rápido como um raio, sempre à frente!"
            "Capitão América" -> "Você é corajoso, leal e um verdadeiro líder."
            "Mulher-Maravilha" -> "Você é poderoso(a), sábio(a) e justo(a)!"
            "Thor" -> "Você tem o poder dos deuses e um coração nobre."
            "Batman" -> "Você usa a inteligência e astúcia como armas!"
            "Superman" -> "Você é o símbolo da esperança, com força, voo e visão além!"
            else -> "Você é único e cheio de potencial!"
        }

        txtMensagem.text = mensagem

        val heroImageRes = when (heroName) {
            "Homem de Ferro" -> R.drawable.ironman
            "Hulk" -> R.drawable.hulk
            "Flash" -> R.drawable.flash
            "Capitão América" -> R.drawable.capitao
            "Mulher-Maravilha" -> R.drawable.mulhermaravilha
            "Thor" -> R.drawable.thor
            "Batman" -> R.drawable.batman
            "Superman" -> R.drawable.superman
            else -> R.drawable.gaviao
        }
        imgHero.setImageResource(heroImageRes)

        btnRetry.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnShare.setOnClickListener {
            val shareText = "Meu resultado do Quiz do Herói:\nVocê é: $heroName\n$mensagem"
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, shareText)
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Compartilhar via"))
        }
    }
}
