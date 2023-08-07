package com.vasyerp.myanimsactivity

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class PieChartView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val slicePaint = Paint()
    private val centerPaint = Paint()
    private val circlePaint = Paint()

    private lateinit var data: List<Float>
    private lateinit var colors: List<Int>

    init {
        slicePaint.style = Paint.Style.FILL
        centerPaint.color = Color.WHITE
        circlePaint.style = Paint.Style.FILL
    }
    fun setDataAndColors(data: List<Float>, colors: List<Int>) {
        this.data = data
        this.colors = colors
        invalidate() // Request a redraw with the new data
    }

    private val dotRadius = 8f // Adjust the size of the dots as needed
    private val dotSpacing = 24f

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            drawPieChart(it)
            drawDots(it)
        }
    }

    private fun drawDots(canvas: Canvas) {
        val chartWidth = width - paddingLeft - paddingRight
        val chartHeight = height - paddingTop - paddingBottom
        val centerX = paddingLeft + chartWidth / 2f
        val dotY = paddingTop + chartHeight + dotRadius

        for ((index, color) in colors.withIndex()) {
            val dotX = centerX - (dotSpacing * (colors.size - 1) / 2f) + (index * dotSpacing)
            circlePaint.color = color
            canvas.drawCircle(dotX, dotY, dotRadius, circlePaint)
        }
    }

    private fun drawPieChart(canvas: Canvas) {
        val chartWidth = width - paddingLeft - paddingRight
        val chartHeight = height - paddingTop - paddingBottom
        val radius = (chartWidth.coerceAtMost(chartHeight) / 2).toFloat()

        val centerX = paddingLeft + chartWidth / 2f
        val centerY = paddingTop + chartHeight / 2f

        val rectF = RectF(
            centerX - radius,
            centerY - radius,
            centerX + radius,
            centerY + radius
        )
        var startAngle = 0f

        for ((index, value) in data.withIndex()) {
            val sweepAngle = value / data.sum() * 360f
            slicePaint.color = colors[index]
            canvas.drawArc(rectF, startAngle, sweepAngle, true, slicePaint)
            startAngle += sweepAngle
        }

        canvas.drawCircle(centerX, centerY, radius / 2, centerPaint)
    }
}
