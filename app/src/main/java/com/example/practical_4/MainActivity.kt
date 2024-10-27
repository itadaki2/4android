package com.example.practical_4

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var spinBeer: Spinner
    private lateinit var btnBeer: Button
    private lateinit var tvBeer: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinBeer = findViewById(R.id.spinBeer)
        btnBeer = findViewById(R.id.btnBeer)
        tvBeer = findViewById(R.id.tvBeer)

        btnBeer.setOnClickListener {
            val selectedBeerType = spinBeer.selectedItem.toString()
            val beers = getBeers(selectedBeerType)
            val resultText = if (beers.isNotEmpty()) {
                "Рекомендуемые сорта: ${beers.joinToString(", ")}"
            } else {
                "Нет доступных сортов."
            }
            tvBeer.text = resultText
        }
    }

    private fun getBeers(selectedBeerType: String): List<String> {
        return when (selectedBeerType) {
            "Pilsners" -> listOf("Budweiser", "Heineken", "Pilsner Urquell")
            "stout" -> listOf("Guinness", "Murphy's", "Left Hand Milk Stout")
            "IPA" -> listOf("Stone IPA", "Lagunitas IPA", "Dogfish Head 60 Minute IPA")
            "Porter" -> listOf("Anchor Porter", "Fuller's London Porter", "Sierra Nevada Porter")
            "ale" -> listOf("Samuel Adams Boston Lager", "Fat Tire Amber Ale", "Newcastle Brown Ale")
            else -> emptyList()
        }
    }
}