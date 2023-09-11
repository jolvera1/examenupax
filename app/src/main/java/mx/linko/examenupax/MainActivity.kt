package mx.linko.examenupax

import android.os.Bundle
import mx.linko.examenupax.base.BaseActivity
import mx.linko.examenupax.customviews.LoaderDialog
import mx.linko.examenupax.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loader = LoaderDialog()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flMain, ListPokedexFragment()).disallowAddToBackStack()
        fragmentTransaction.commit()
    }
}