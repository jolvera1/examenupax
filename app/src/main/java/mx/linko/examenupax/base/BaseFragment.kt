package com.olvera.siruacademia.Base

import androidx.fragment.app.Fragment
import mx.linko.examenupax.R
import mx.linko.examenupax.customviews.LoaderDialog

open class BaseFragment: Fragment() {
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
            loader.show(parentFragmentManager, "")
        } else {
            loader.dialog?.dismiss()
        }
    }

    fun back() {
        activity?.let { a ->
            a.onBackPressed()
        }
    }
    fun changeFragment(fragment:Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flMain, fragment).addToBackStack(tag).commit()
    }
}