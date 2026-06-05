package com.example.travelpackinglistapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnDisplay = findViewById<Button>(R.id.btnDisplayAll)
        val btnQuantity = findViewById<Button>(R.id.btnDisplayQuantity)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val txtOutput = findViewById<TextView>(R.id.txtResults)

        btnDisplay.setOnClickListener {

            var output = ""

            for (i in MainActivity.itemArray.indices) {

                output += """
                    Item: ${MainActivity.itemArray[i]}
                    Category: ${MainActivity.categoryArray[i]}
                    Quantity: ${MainActivity.quantityArray[i]}
                    Comments: ${MainActivity.commentArray[i]}

                """.trimIndent()

                output += "\n\n"
            }

            txtOutput.text = output

            Log.d("PACKING_APP", "Displayed full packing list")
        }

        btnQuantity.setOnClickListener {

            var output = ""

            for (i in MainActivity.quantityArray.indices) {

                if (MainActivity.quantityArray[i] >= 2) {

                    output +=
                        "${MainActivity.itemArray[i]} " +
                                "- Quantity: ${MainActivity.quantityArray[i]}\n"
                }
            }

            txtOutput.text = output

            Log.d("PACKING_APP", "Displayed quantity >= 2")
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}




