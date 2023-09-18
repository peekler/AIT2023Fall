package hu.ait.tictactoe.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class TicTacToeView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paintBackground = Paint()
    private val paintLine = Paint()

    private var circles = mutableListOf<PointF>()

    init {
        paintBackground.color = Color.BLACK
        paintBackground.style = Paint.Style.FILL

        paintLine.color = Color.WHITE
        paintLine.style = Paint.Style.STROKE
        paintLine.strokeWidth = 5f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paintBackground)
        
        //canvas?.drawLine(0f, 0f, width.toFloat(), height.toFloat(), paintLine)

        for (circle in circles) {
            canvas?.drawCircle(circle.x, circle.y, 50f, paintLine)
        }
        
        drawGameArea(canvas)
    }

    private fun drawGameArea(canvas: Canvas?) {
        // border
        canvas?.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paintLine)
        // two horizontal lines
        canvas?.drawLine(0f, (height / 3).toFloat(), width.toFloat(), (height / 3).toFloat(),
            paintLine)
        canvas?.drawLine(0f, (2 * height / 3).toFloat(), width.toFloat(),
            (2 * height / 3).toFloat(), paintLine)

        // two vertical lines
        canvas?.drawLine((width / 3).toFloat(), 0f, (width / 3).toFloat(), height.toFloat(),
            paintLine)
        canvas?.drawLine((2 * width / 3).toFloat(), 0f, (2 * width / 3).toFloat(), height.toFloat(),
            paintLine)
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {

        circles.add(PointF(event!!.x, event!!.y))

        // this will redraw the TicTacToeView
        invalidate()

        return true
    }

    fun resetGame(){
        circles.clear()
        invalidate()
    }

}