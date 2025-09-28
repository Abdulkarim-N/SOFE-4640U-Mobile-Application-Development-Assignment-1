
package com.example.assignment1_100748590

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.widget.TextView


class ResultScreenActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_calculator_screen)


        // to allow going back and forth between pages
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }


        //grab all the specific XML elements to then display the values
        val resultString = findViewById<TextView>(R.id.resultString)
        val resultValue = findViewById<TextView>(R.id.resultValue)
        val emiString = findViewById<TextView>(R.id.emiRes)
        val monthlyIncomeString = findViewById<TextView>(R.id.monthlyIncomeRes)
        val monthlyExpenseString = findViewById<TextView>(R.id.monthlyExpenseRes)


        //grab the colour values
        val greenColour = Color.GREEN
        val redColour = Color.RED

        // get all the intents from the previous screen to then display in the result page
        val sum = intent.getDoubleExtra("sum", 0.0)
        val emi = intent.getDoubleExtra("EMI", 0.0)
        val monthlyIncome = intent.getIntExtra("monthlyIncome", 0)
        val monthlyExpenses = intent.getIntExtra("monthlyExpenses", 0)

        //set the text values to be the numbers inputted prior so the user can see them
        emiString.text = "EMI calculation: $%.2f".format(emi)
        monthlyIncomeString.text = "Monthly Income: $$monthlyIncome "
        monthlyExpenseString.text = "Monthly Expenses: $$monthlyExpenses "


        //simple check, if its greater than 0 its a positive amount, meaning its savings

        if (sum >= 0){
            resultString.setTextColor(greenColour)
            resultValue.setTextColor(greenColour)
            resultString.text = "Savings per Month is:"
            resultValue.text = "$%.2f".format(sum)
        } //if its less than 0 then it will be a negative amount, its a deficit
        else{
            resultString.setTextColor(redColour)
            resultValue.setTextColor(redColour)
            resultString.text = "Deficit per Month is:"
            resultValue.text = "$%.2f".format(sum*-1)
        }

    }


}