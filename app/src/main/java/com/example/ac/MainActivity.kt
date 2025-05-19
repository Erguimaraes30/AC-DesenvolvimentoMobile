package com.example.ac

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val editName = findViewById<EditText>(R.id.editName)

        btnStart.setOnClickListener {
            val name = editName.text.toString()
            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra("USERNAME", name)
            startActivity(intent)
        }
    }
}
