package tools

import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager

class Assistant(private var context: Context) {

    var user: String?
        get() {

            val sp = context.getSharedPreferences("user", 0)
            return sp.getString("user", "")

        }
        set(user) {

            val editor = context.getSharedPreferences("user", 0).edit()
            editor.putString("user", user)
            editor.commit()

        }

    var token: String?
        get() {

            val sp = context.getSharedPreferences("user", 0)
            return sp.getString("token", "")

        }
        set(user) {

            val editor = context.getSharedPreferences("user", 0).edit()
            editor.putString("token", user)
            editor.commit()

        }

    var splash: String?
        get() {

            val sp = context.getSharedPreferences("app", 0)
            return sp.getString("splash", "")

        }
        set(user) {

            val editor = context.getSharedPreferences("app", 0).edit()
            editor.putString("splash", user)
            editor.commit()

        }

    fun displayHeight(): Int {

        val metrics = DisplayMetrics()
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(metrics)

        return metrics.heightPixels

    }

    fun displayWidth(): Int {


        val metrics = DisplayMetrics()
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(metrics)

        return metrics.widthPixels

    }

    fun setViewHeightByHeight(view: View, x: Double, y: Double) {

        val metrics = DisplayMetrics()
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(metrics)

        view.layoutParams.height = (metrics.heightPixels * x / y).toInt()

    }

    fun setViewHeightByWidth(view: View, x: Double, y: Double) {

        val metrics = DisplayMetrics()
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(metrics)

        view.layoutParams.height = (metrics.widthPixels * x / y).toInt()

    }

    fun setViewWidthByHeight(view: View, x: Double, y: Double) {

        val metrics = DisplayMetrics()
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(metrics)

        view.layoutParams.width = (metrics.heightPixels * x / y).toInt()

    }

    fun setViewWidthByWidth(view: View, x: Double, y: Double) {

        val metrics = DisplayMetrics()
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(metrics)

        view.layoutParams.width = (metrics.widthPixels * x / y).toInt()

    }

}
