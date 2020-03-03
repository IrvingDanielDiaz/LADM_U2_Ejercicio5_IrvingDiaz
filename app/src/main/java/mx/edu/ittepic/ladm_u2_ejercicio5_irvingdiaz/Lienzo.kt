package mx.edu.ittepic.ladm_u2_ejercicio5_irvingdiaz

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Lienzo (p:MainActivity) : View(p){
    var down = false
    var puntero = p
    var cx = 150f
    var cy = 150f
    var tx = 733f
    var ty = 818f

    var cxa = cx
    var cya = cy



    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()

        canvas.drawColor(Color.BLACK)

        //Dibujando un circulo rojo con contorno blanco
        paint.color = Color.RED
        canvas.drawCircle(cx,cy,120f, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 10f
        canvas.drawCircle(cx,cy,120f, paint)

        //Dibujando un cuadrado VERDE CONTORNO AZUL
        paint.style = Paint.Style.FILL
        paint.color = Color.GREEN
        canvas.drawRect(tx,ty,tx+200,ty+200,paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLUE
        canvas.drawRect(tx,ty,tx+200,ty+200,paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action){
            MotionEvent.ACTION_DOWN->{
                down = true
                puntero.setTitle("DOWN ${event.x.toInt()},${event.y.toInt()}")
                cx = event.x
                cy = event.y
                tx = event.x
                ty = event.y
            }
            MotionEvent.ACTION_MOVE->{
                puntero.setTitle("MOVE ${event.x.toInt()},${event.y.toInt()}")
                cx = event.x
                cy = event.y
                tx = event.x
                ty = event.y
            }
            MotionEvent.ACTION_UP->{
                puntero.setTitle("UP ${event.x.toInt()},${event.y.toInt()}")
                cx = event.x
                cy = event.y
                tx = event.x
                ty = event.y
            }
        }

        invalidate()
        down = false
        return true

    }

}