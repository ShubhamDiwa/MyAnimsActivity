package com.vasyerp.myanimsactivity

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class BarChartView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val barPaint = Paint()
    private val axisPaint = Paint()

    // Sample data for the chart
    private val data = listOf(20f, 50f, 30f, 80f, 60f)

    init {
        barPaint.color = Color.BLUE
        axisPaint.color = Color.BLACK
        axisPaint.strokeWidth = 5f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            drawBars(it)
            drawAxis(it)
        }
    }

    private fun drawBars(canvas: Canvas) {
        val chartWidth = width - paddingLeft - paddingRight
        val chartHeight = height - paddingTop - paddingBottom
        val barWidth = chartWidth / data.size.toFloat()

        var startX = paddingLeft.toFloat()

        for (value in data) {
            val barHeight = (value / data.maxOrNull()!!) * chartHeight
            canvas.drawRect(
                startX,
                height - paddingBottom - barHeight,
                startX + barWidth,
                height - paddingBottom.toFloat(),
                barPaint
            )
            startX += barWidth
        }
    }

    private fun drawAxis(canvas: Canvas) {
        canvas.drawLine(
            paddingLeft.toFloat(),
            height - paddingBottom.toFloat(),
            width - paddingRight.toFloat(),
            height - paddingBottom.toFloat(),
            axisPaint
        )
        canvas.drawLine(
            paddingLeft.toFloat(),
            paddingTop.toFloat(),
            paddingLeft.toFloat(),
            height - paddingBottom.toFloat(),
            axisPaint
        )
    }
}
