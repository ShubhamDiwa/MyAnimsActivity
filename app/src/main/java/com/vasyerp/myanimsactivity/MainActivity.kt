package com.vasyerp.myanimsactivity

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val balloonTextView: TextView = findViewById(R.id.balloonTextView)
//        val balloonButton: Button = findViewById(R.id.button)
//
//        balloonButton.setOnClickListener {
//            animateBalloon(balloonButton)
//
//        }

        // You can customize the TextView further if needed
        // For example, change the text size and alignment
//        balloonTextView.textSize = 18f
//        balloonTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
//
//        balloonTextView.setOnClickListener {
//            // Create an ObjectAnimator for scaling
//            val scaleX = ObjectAnimator.ofFloat(balloonTextView, View.SCALE_X, 1.0f, 1.2f, 1.0f)
//            val scaleY = ObjectAnimator.ofFloat(balloonTextView, View.SCALE_Y, 1.0f, 1.2f, 1.0f)
//
//            // Set the animation duration
//            scaleX.duration = 300
//            scaleY.duration = 300
//
//            // Play the animations together
//            scaleX.start()
//            scaleY.start()
//        }


    }

    private fun animateBalloon(view:View) {
        val balloonAnimator = AnimatorInflater.loadAnimator(this, R.animator.ballon_animator)
        balloonAnimator.setTarget(view)
        balloonAnimator.start()

    }
}