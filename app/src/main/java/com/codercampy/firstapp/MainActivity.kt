package com.codercampy.firstapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codercampy.firstapp.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    var i = 0

    private lateinit var binding: ActivityMainBinding

    /**
     * This block will run when our app runs for the first time
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            showMsg("Closing")
            finish()
        }

        binding.btnPlus.setOnClickListener {
            //Runs when + btn is clicked
            calculate("+")
        }

        binding.btnMinus.setOnClickListener {
            //Runs when - btn is clicked
            calculate("-")
        }

        binding.btnMultiplication.setOnClickListener {
            //Runs when * btn is clicked
            calculate("*")
        }

        binding.btnDivide.setOnClickListener {
            //Runs when / btn is clicked
            calculate("/")
        }

    }

    private fun showMsg(value: String) {
        Toast.makeText(
            this,
            value,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun calculate(sign: String) {
        val n1 = binding.et1.text.toString().toFloatOrNull()
        val n2 = binding.et2.text.toString().toFloatOrNull()

        if (n1 == null || n2 == null) {
            showMsg("Please enter a valid number")
            return
        }

        if (n2 == 0f && sign == "/") {
            showMsg("Can't divide with 0")
            return
        }


        val formatter = DecimalFormat("#.##")
        val result = when (sign) {
            "+" -> n1 + n2
            "-" -> n1 - n2
            "*" -> n1 * n2
            "/" -> n1 / n2
            else -> 0
        }
        binding.tv.text = formatter.format(result)

    }


}