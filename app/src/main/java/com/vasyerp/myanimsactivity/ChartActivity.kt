package com.vasyerp.myanimsactivity

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

class ChartActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)

        val chartView = findViewById<View>(R.id.pieChartView)

        val pieChartView = PieChartView(this)

        // Set layout parameters for the custom view
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            resources.getDimensionPixelSize(R.dimen.pie_chart_height)
        )

        // Set the custom view's layout parameters and add it to the activity's layout
        pieChartView.layoutParams = layoutParams
//        val parentLayout = findViewById<LinearLayout>(R.id.Linearlayout) // Replace 'parentLayout' with the ID of the parent layout in your activity_chart.xml
//        parentLayout.addView(pieChartView)

        setContentView(pieChartView)

        // Here you can set your custom colors for the pie chart
        val customColors = listOf(Color.parseColor("#76A9DA"),
        Color.parseColor("#96D5AB"),
        Color.parseColor("#5FA098"),
        Color.parseColor("#8F6BAB"),
        Color.parseColor("#A6F691"),
        Color.parseColor("#9FADBD"),
        Color.parseColor("#D590AC"),
        Color.parseColor("#E58E77"),
        Color.parseColor("#999966")
        )
        // Set the data and custom colors for the pie chart dynamically
        pieChartView.setDataAndColors(listOf(20f, 30f, 40f, 10f,45f,33f,15f,25f,5f)
        , customColors)
    }
}