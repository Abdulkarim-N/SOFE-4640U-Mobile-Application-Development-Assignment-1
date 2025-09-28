package com.example.assignment1_100748590

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    //boilerplate code
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //additional toolbar boilerplate code
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)



        // finding buttons for onclick events
        val emiCalcButton = findViewById<Button>(R.id.emiCalcButton)

        //on click events to change pages/create intents
        emiCalcButton.setOnClickListener {
            val intent = Intent(this, EmiCalculatorActivity::class.java)
            startActivity(intent)
        }

    }

// needed toolbar code
    override fun onSupportNavigateUp(): Boolean {
        finish() // closes current activity
        return true
    }
}