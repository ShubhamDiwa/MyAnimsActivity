package com.vasyerp.myanimsactivity

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class PieChartViewD(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val data = mutableListOf<DataItem>()

    // Add data for the pie chart
    fun setData(dataList: List<DataItem>) {
        data.clear()
        data.addAll(dataList)
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val centerY = height / 2f
        val radius = (Math.min(width, height) / 2f) * 0.8f // 80% of the view's dimensions

        drawPieChart(canvas, centerX, centerY, radius)
        drawBottomDot(canvas, centerX, centerY, radius)
    }

    private fun drawPieChart(canvas: Canvas, centerX: Float, centerY: Float, radius: Float) {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        var startAngle = 0f

        for (dataItem in data) {
            paint.color = dataItem.color
            val sweepAngle = 360f * (dataItem.value / getTotalValue())

            canvas.drawArc(
                centerX - radius, centerY - radius,
                centerX + radius, centerY + radius,
                startAngle, sweepAngle, true, paint
            )

            startAngle += sweepAngle
        }
    }

    private fun drawBottomDot(canvas: Canvas, centerX: Float, centerY: Float, radius: Float) {
        val dotRadius = 12f // Adjust the size of the dot
        val dotY = centerY + radius + dotRadius +10f // Move the dot below the chart

        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.BLACK
        canvas.drawCircle(centerX, dotY, dotRadius, paint)
    }
    private fun getTotalValue(): Float {
        var total = 0f
        data.forEach { total += it.value }
        return total
    }

    data class DataItem(val value: Float, val color: Int)
}
