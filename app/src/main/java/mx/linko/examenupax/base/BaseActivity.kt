package mx.linko.examenupax.base

import androidx.appcompat.app.AppCompatActivity
import mx.linko.examenupax.customviews.LoaderDialog

open class BaseActivity: AppCompatActivity() {
    lateinit var loader: LoaderDialog
    override fun onStart() {
        super.onStart()
        showingLoader(false)
    }
    override fun onResume() {
        super.onResume()
        showingLoader(false)
    }
    fun showingLoader(show: Boolean) {
        if (show) {
            loader.show(supportFragmentManager, "")
        } else {
            loader.dialog?.dismiss()
        }
    }



}