
package com.example.assignment1_100748590

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class IncomeExpenseCalculatorActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.income_expense_layout)


        // to allow going back and forth between pages
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }


        //get all the inputs from the user
        val resultButton = findViewById<Button>(R.id.resultButton)
        val monthlyIncomeText = findViewById<EditText>(R.id.monthlyIncome)
        val monthlyExpensesText = findViewById<EditText>(R.id.monthlyExpenses)



        //get the EMI variable from the intent
        val EMI = intent.getDoubleExtra("EMI", 0.0)

        resultButton.setOnClickListener {

            //parse the inputs into ints
            val monthlyIncome: Int? = monthlyIncomeText.text.toString().toIntOrNull()
            val monthlyExpenses: Int? = monthlyExpensesText.text.toString().toIntOrNull()

            //basic check to see if the form is valid (all inputs exist) only then will it do the calculations
            if (monthlyIncome != null && monthlyExpenses != null){

                var sum = monthlyIncome - monthlyExpenses - EMI

                //create the intent, pass variables to the intent
                val intent = Intent(this, ResultScreenActivity::class.java)
                intent.putExtra("sum", sum)
                intent.putExtra("monthlyIncome", monthlyIncome)
                intent.putExtra("monthlyExpenses", monthlyExpenses)
                intent.putExtra("EMI", EMI)
                startActivity(intent)
            }


        }


    }


}