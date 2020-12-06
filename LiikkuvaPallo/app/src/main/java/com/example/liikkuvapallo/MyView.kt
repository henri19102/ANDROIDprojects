package com.example.liikkuvapallo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var x1 = 10F
    var y1 = 10F
    val paint = Paint()
    val paint2 = Paint()
    var tex = "test"

    override fun onDraw(canvas: Canvas?) {
        paint2.textSize=50F
        canvas?.drawText(tex, (width.toFloat()/3), (height.toFloat()/2)+150, paint2)
        canvas?.drawOval((width.toFloat()/2)+x1, (height.toFloat()/2)+y1, (width.toFloat()/2)+x1+50F, (height.toFloat()/2)+y1+50F, paint)
        super.onDraw(canvas)
    }

    fun setXY(x2: Float, y2: Float){
        x1 = x2
        y1 = y2
        invalidate()
    }
    fun setTexti (tee: String) {
        tex = tee
        invalidate()
    }
}