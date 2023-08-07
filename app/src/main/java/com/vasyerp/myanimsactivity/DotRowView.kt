package com.vasyerp.myanimsactivity

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

// DotRowView.java


class DotRowView : View {
    private var paint: Paint? = null

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        paint = Paint()
        paint!!.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var x = (width - (DOT_COLORS.size * (DOT_SIZE + DOT_SPACING) - DOT_SPACING)) / 2
        val y = height / 2
        for (color in DOT_COLORS) {
            paint!!.color = color
            canvas.drawCircle(
                x.toFloat(), y.toFloat(), (DOT_SIZE / 2).toFloat(),
                paint!!
            )
            x += DOT_SIZE + DOT_SPACING
        }
    }

    companion object {
        const val DOT_SIZE = 20
        const val DOT_SPACING = 10
        val DOT_COLORS = intArrayOf(
            Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA
        )
    }
}
