package com.example.assignment1final

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    //define and initialise functions
    lateinit var ageInput: EditText
    lateinit var clearButton: Button
    lateinit var generateButton: Button
    lateinit var textViewresults: TextView

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//identify
        ageInput = findViewById(R.id.edit_Age)
        clearButton = findViewById(R.id.btn_Clear)
        generateButton = findViewById(R.id.btn_Generate)
        textViewresults = findViewById(R.id.textview_results)

        // onClick listener for clear button
        clearButton.setOnClickListener {
            //clear edit text
            ageInput.text.clear()
        }


        // whole numbers function onclick listener
        generateButton.setOnClickListener {

            //get age from editText

            val enterAge = ageInput.text.toString().trim()

            //confirm if input is empty
            if (enterAge.isNotEmpty()) {
                try {
                    //convert age input to integer

                    val age = enterAge.toInt()

                    // limit age range

                    if (age in 20..100){

                        //call function to match person for the age

                        val matchedPerson = findMatchedPerson(age)

                        textViewresults.text = "The Age is out of Range. Please enter an age between 20 and 100"
                    }
                } catch (e: NumberFormatException) {
                    // display error message if input is not valid integer

                    textViewresults.text = "The age is an invalid format. Please enter valid integer age"
                }
            } else {
                // display error message if input is empty

                textViewresults.text = "Please enter an age"

            }

        }

//enable function by setting click listener for the button
        generateButton.setOnClickListener {
            //assign value to each function

            val enterAge = ageInput.text.toString().toIntOrNull()

            //check if the input is not null

            if (enterAge != null) {
                // calling function to find matched person and show results in TextView

                val matchedPerson = findMatchedPerson(enterAge)
                textViewresults.text = matchedPerson
            } else {
                // Disaplay error if input not valid integer

                textViewresults.text = "Please enter a valid age"
            }
        }

    }

    //finding a historical figure who password away at given age
    private fun findMatchedPerson(age:Int): String {
        // Map of famous people and ages of their death

        val famousPeople = mapOf(
            "Cameron Boyce" to 20,
            "Aliyah" to 22,
            "Selena" to 23,
            "Notorious B.I.G" to 24,
            "Tupac Shakur" to 25,
            "Andres Escobar" to 27,
            "Senzo Meyiwa" to 30,
            "Princess Diana" to 36,
            "Brenda Fassie" to 39,
            "Kobe Bryant" to 41,
            "Lucky Dube" to 43,
            "John F. Kennedy" to 46,
            "Gianni Versace" to 50,
            "William Shakespeare" to 52,
            "Prince" to 57,
            "Diego Maradona" to 60,
            "James Balwin" to 63,
            "Leonardo Da Vinci" to 67,
            "Oliver Tambo" to 75,
            "Nikita Krushchev" to 77,
            "Winnie Mandela" to 81,
            "Walter Sisulu" to 90,
            "Queen Elizabeth II" to 96,
        )

        // iterate through map entries
        for ((person, personAge) in famousPeople)
        // confirm if age matches
            if (age == personAge) {

                // display matched person

                return "$person passed away at age $age"
            }


                // display if no match found

                return "No historical figure found at age $age"


        }



    }
















