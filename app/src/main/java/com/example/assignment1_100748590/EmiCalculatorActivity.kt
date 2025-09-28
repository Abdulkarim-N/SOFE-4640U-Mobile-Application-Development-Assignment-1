package com.example.assignment1_100748590

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlin.math.pow

class EmiCalculatorActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emi_calculator_layout)

        // to allow going back and forth between pages, if the user wants to go back they can

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        val incomeExpenseButton = findViewById<Button>(R.id.incomeExpenseButton)

        //extract the values, convert them to ints to use for calculations
        val emiLoanAmountText = findViewById<EditText>(R.id.emiLoanAmount)
        val emiInterestRateText = findViewById<EditText>(R.id.emiInterestRate)
        val emiTenureText = findViewById<EditText>(R.id.emiTenure)


        // On click event checks if the values exist and are not null, then does all the calculations
        // passes the calculated EMI value in the intent, then goes to the next page
        incomeExpenseButton.setOnClickListener {
            val intent = Intent(this, IncomeExpenseCalculatorActivity::class.java)

            //convert values to int
            val emiLoanAmount: Int? = emiLoanAmountText.text.toString().toIntOrNull()
            val emiInterestRate: Double? = emiInterestRateText.text.toString().toDoubleOrNull()
            val emiTenure: Int? = emiTenureText.text.toString().toIntOrNull()

            println("int amounts or maybe null: $emiLoanAmount, $emiInterestRate, $emiTenure")
            println("TEXT: $emiLoanAmountText, $emiInterestRateText, $emiTenureText")
            //checks if values are not null (they exist or not)
            if(emiLoanAmount != null &&  emiInterestRate!= null && emiTenure != null){

                //Simple EMI calculator, breaking up inputs for readability, n is (1+r)^n
                val monthlyInterestRate = emiInterestRate.div((12*100))
                val emiTenureInMonths = emiTenure.times(12)
                val compoundInterestFactor = (1 + monthlyInterestRate).toDouble().pow(emiTenureInMonths)

                val numerator = emiLoanAmount * monthlyInterestRate * compoundInterestFactor
                val denomintaor = compoundInterestFactor - 1

                val EMI = numerator/denomintaor
                //puts the value in the intent, then starts the activity
                intent.putExtra("EMI", EMI)
                startActivity(intent)

            }

        }


    }


}