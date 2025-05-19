package com.example.ac

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val spinnerHobby = findViewById<Spinner>(R.id.spinnerHobby)
        val hobbies = arrayOf("Lutar", "Estudar", "Explorar", "Voar", "Meditar", "Criar tecnologia")
        spinnerHobby.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, hobbies)

        val spinnerCombat = findViewById<Spinner>(R.id.spinnerCombat)
        val combats = arrayOf("Combate corpo a corpo", "Combate à distância", "Estratégia e furtividade")
        spinnerCombat.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, combats)

        val checkCapa = findViewById<CheckBox>(R.id.checkCapa)
        val seekPower = findViewById<SeekBar>(R.id.seekPower)

        val radioGroupHabilidade = findViewById<RadioGroup>(R.id.radioGroupHabilidade)
        val radioGroupTemperamento = findViewById<RadioGroup>(R.id.radioGroupTemperamento)

        val btnResult = findViewById<Button>(R.id.btnResult)

        btnResult.setOnClickListener {
            val selectedHabilidadeId = radioGroupHabilidade.checkedRadioButtonId
            val selectedTemperamentoId = radioGroupTemperamento.checkedRadioButtonId

            if (selectedHabilidadeId == -1 || selectedTemperamentoId == -1) {
                Toast.makeText(this, "Por favor, responda todas as perguntas!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedHabilidade = findViewById<RadioButton>(selectedHabilidadeId).text.toString()
            val selectedTemperamento = findViewById<RadioButton>(selectedTemperamentoId).text.toString()

            val hobby = spinnerHobby.selectedItem.toString()
            val combate = spinnerCombat.selectedItem.toString()
            val usaCapa = checkCapa.isChecked
            val poder = seekPower.progress

            val pontos = mutableMapOf(
                "Homem de Ferro" to 0,
                "Hulk" to 0,
                "Flash" to 0,
                "Capitão América" to 0,
                "Mulher-Maravilha" to 0,
                "Thor" to 0,
                "Batman" to 0,
                "Superman" to 0
            )

            when (selectedHabilidade) {
                "Inteligência" -> {
                    pontos["Homem de Ferro"] = pontos["Homem de Ferro"]!! + 3
                    pontos["Batman"] = pontos["Batman"]!! + 3
                }
                "Força" -> {
                    pontos["Hulk"] = pontos["Hulk"]!! + 3
                    pontos["Mulher-Maravilha"] = pontos["Mulher-Maravilha"]!! + 2
                    pontos["Thor"] = pontos["Thor"]!! + 3
                    pontos["Superman"] = pontos["Superman"]!! + 5
                }
                "Velocidade" -> {
                    pontos["Flash"] = pontos["Flash"]!! + 3
                    pontos["Superman"] = pontos["Superman"]!! + 1
                }
            }

            when (selectedTemperamento) {
                "Calmo" -> {
                    pontos["Capitão América"] = pontos["Capitão América"]!! + 2
                    pontos["Batman"] = pontos["Batman"]!! + 1
                    pontos["Superman"] = pontos["Superman"]!! + 2

                }
                "Explosivo" -> {
                    pontos["Hulk"] = pontos["Hulk"]!! + 1
                    pontos["Thor"] = pontos["Thor"]!! + 1
                    pontos["Flash"] = pontos["Flash"]!! + 1
                }
                "Estratégico" -> {
                    pontos["Homem de Ferro"] = pontos["Homem de Ferro"]!! + 2
                    pontos["Batman"] = pontos["Batman"]!! + 2
                    pontos["Capitão América"] = pontos["Capitão América"]!! + 1
                    pontos["Mulher-Maravilha"] = pontos["Mulher-Maravilha"]!! + 1
                }
            }


            when (hobby) {
                "Estudar" -> {
                    pontos["Homem de Ferro"] = pontos["Homem de Ferro"]!! + 2
                    pontos["Batman"] = pontos["Batman"]!! + 2
                }
                "Lutar" -> {
                    pontos["Hulk"] = pontos["Hulk"]!! + 1
                    pontos["Capitão América"] = pontos["Capitão América"]!! + 2
                    pontos["Mulher-Maravilha"] = pontos["Mulher-Maravilha"]!! + 1
                }
                "Explorar" -> {
                    pontos["Capitão América"] = pontos["Capitão América"]!! + 2
                    pontos["Thor"] = pontos["Thor"]!! + 1
                }
                "Voar" -> {
                    pontos["Homem de Ferro"] = pontos["Homem de Ferro"]!! + 1
                    pontos["Mulher-Maravilha"] = pontos["Mulher-Maravilha"]!! + 2
                    pontos["Thor"] = pontos["Thor"]!! + 2
                    pontos["Superman"] = pontos["Superman"]!! + 4
                }
                "Meditar" -> {
                    pontos["Mulher-Maravilha"] = pontos["Mulher-Maravilha"]!! + 1
                    pontos["Batman"] = pontos["Batman"]!! + 1
                    pontos["Flash"] = pontos["Flash"]!! + 2
                }
                "Criar tecnologia" -> {
                    pontos["Homem de Ferro"] = pontos["Homem de Ferro"]!! + 3
                    pontos["Batman"] = pontos["Batman"]!! + 2
                }
            }

            when (combate) {
                "Combate corpo a corpo" -> {
                    pontos["Hulk"] = pontos["Hulk"]!! + 2
                    pontos["Capitão América"] = pontos["Capitão América"]!! + 2
                    pontos["Mulher-Maravilha"] = pontos["Mulher-Maravilha"]!! + 2
                    pontos["Batman"] = pontos["Batman"]!! + 2
                    pontos["Superman"] = pontos["Superman"]!! + 3
                }
                "Combate à distância" -> {
                    pontos["Homem de Ferro"] = pontos["Homem de Ferro"]!! + 3
                    pontos["Thor"] = pontos["Thor"]!! + 2
                }
                "Estratégia e furtividade" -> {
                    pontos["Batman"] = pontos["Batman"]!! + 3
                    pontos["Capitão América"] = pontos["Capitão América"]!! + 1
                }
            }


            if (usaCapa) {
                pontos["Thor"] = pontos["Thor"]!! + 2
                pontos["Batman"] = pontos["Batman"]!! + 2
                pontos["Superman"] = pontos["Superman"]!! + 2
            } else {
                pontos["Flash"] = pontos["Flash"]!! + 1
                pontos["Capitão América"] = pontos["Capitão América"]!! + 1
                pontos["Homem de Ferro"] = pontos["Homem de Ferro"]!! + 1
                pontos["Mulher-Maravilha"] = pontos["Mulher-Maravilha"]!! + 1
                pontos["Hulk"] = pontos["Hulk"]!! + 1
            }

            //
            when {
                poder >= 8 -> {
                    pontos["Hulk"] = pontos["Hulk"]!! + 3
                    pontos["Thor"] = pontos["Thor"]!! + 2
                    pontos["Superman"] = pontos["Superman"]!! + 3
                }
                poder in 5..7 -> {
                    pontos["Capitão América"] = pontos["Capitão América"]!! + 2
                    pontos["Flash"] = pontos["Flash"]!! + 2
                    pontos["Mulher-Maravilha"] = pontos["Mulher-Maravilha"]!! + 1
                }
                else -> {
                    pontos["Batman"] = pontos["Batman"]!! + 3
                    pontos["Homem de Ferro"] = pontos["Homem de Ferro"]!! + 3
                }
            }

            val heroi = pontos.maxByOrNull { it.value }?.key ?: "Capitão América"


            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("HERO", heroi)
            startActivity(intent)
        }
    }
}
