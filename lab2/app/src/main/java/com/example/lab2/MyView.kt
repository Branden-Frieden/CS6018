package com.example.lab2

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
class MyView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var bitmap = Bitmap.createBitmap(context.display!!.width, context.display!!.height, Bitmap.Config.ARGB_8888)

    private var bitmapCanvas = Canvas(bitmap)
    private val paint = Paint()
    private val rect: Rect by lazy {Rect(0,0,width, height)}

    var lastX = 0f
    var lastY = 0f
    var currentX = 0f
    var currentY = 0f


    fun setMap(map : Bitmap) {
        this.bitmap = map
        this.bitmapCanvas = Canvas(bitmap)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.strokeWidth = 10f

        if(!(lastX == 0f && lastY == 0f)) {
            bitmapCanvas.drawLine(lastX, lastY, currentX, currentY, paint)
        }
        canvas?.drawBitmap(bitmap, null, rect, paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)

        lastX = currentX
        lastY = currentY

        val x: Float = this.getLeft() + event!!.x // X in Screen Coordinates
        val y: Float = this.getTop() + event.y

        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {

                bitmapCanvas.drawCircle(x, y, 5f, paint)
                lastX = x!!
                lastY = y!!
                currentX = x!!
                currentY = y!!
            }
            MotionEvent.ACTION_MOVE -> {
                currentX = x!!
                currentY = y!!
            }
            MotionEvent.ACTION_UP -> {
                bitmapCanvas.drawCircle(x, y, 5f, paint)
                currentX = 0f
                currentY = 0f
                lastX = 0f
                lastY = 0f
            }
            else -> return false
        }

        invalidate()
        return true

    }
}