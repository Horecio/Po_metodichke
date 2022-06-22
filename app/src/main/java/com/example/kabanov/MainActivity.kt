package com.example.kabanov

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.Boolean

class MainActivity : AppCompatActivity()
{
    private lateinit var Button : Button
    private lateinit var Button2 : Button
    private lateinit var Button3 : Button
    private lateinit var nextButton : Button
    private lateinit var questionTextView: TextView

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, true),
        Question(R.string.question_africa, true),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))
    private var currentIndex = 0



   /* private fun  checkAnswer (userAnswer: Boolean1){
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer){
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }*/
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Button = findViewById(R.id.button)
        Button2 = findViewById(R.id.button2)
        Button3 = findViewById(R.id.button3)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)
        Button.setOnClickListener{
            checkAnswer(true)
        }
        Button2.setOnClickListener{
            checkAnswer(false)
        }
        Button3.setOnClickListener {
            if(currentIndex == 0)currentIndex =+ questionBank.size
            currentIndex = (currentIndex - 1) %questionBank.size
            updateQuestion()
        }
        nextButton.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }

        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }
    private fun updateQuestion(){
        val questionTextResId = questionBank [currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }
    private fun checkAnswer(userAnswer: kotlin.Boolean) {
        val correctAnswer: Boolean = questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()

        Button.setOnClickListener {
            view: View -> checkAnswer(true)
        }
        Button2.setOnClickListener {
            view: View -> checkAnswer(false)
        }
    }


}

