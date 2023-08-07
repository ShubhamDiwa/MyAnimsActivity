package com.vasyerp.myanimsactivity

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Test : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val myView : PieChartViewD = findViewById(R.id.myView)

// Sample data for the pie chart
        val dataList = listOf(
            PieChartViewD.DataItem(30f, Color.RED),
            PieChartViewD.DataItem(40f, Color.BLUE),
            PieChartViewD.DataItem(15f, Color.GREEN),
            PieChartViewD.DataItem(10f, Color.YELLOW),
            PieChartViewD.DataItem(5f, Color.MAGENTA)
        )

        myView.setData(dataList)

    }
}