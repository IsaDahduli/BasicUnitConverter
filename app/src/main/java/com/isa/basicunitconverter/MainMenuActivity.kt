package com.isa.basicunitconverter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainMenuActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    fun goDistances(view: View?) {
        val btn = findViewById<View>(R.id.button_go_to_distances) as Button

        btn.setOnClickListener {
            startActivity(
                Intent(
                    this@MainMenuActivity, MainActivityDistances::class.java
                )
            )
        }
    }

    fun goToTemperature(view: View?) {
        val btn = findViewById<View>(R.id.button_go_to_temperature) as Button

        btn.setOnClickListener {
            startActivity(
                Intent(
                    this@MainMenuActivity, MainActivityTemperature::class.java
                )
            )
        }
    }

    fun goToFrequencies(view: View?) {
        val btn = findViewById<View>(R.id.button_go_to_frequencies) as Button

        btn.setOnClickListener {
            startActivity(
                Intent(
                    this@MainMenuActivity, MainActivityFrequency::class.java
                )
            )
        }
    }

    fun goDataRate(view: View?) {
        val btn = findViewById<View>(R.id.button_go_to_datarate) as Button

        btn.setOnClickListener {
            startActivity(
                Intent(
                    this@MainMenuActivity, MainActivityDataRate::class.java
                )
            )
        }
    }
}