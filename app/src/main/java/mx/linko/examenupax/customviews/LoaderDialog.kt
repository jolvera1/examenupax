package mx.linko.examenupax.customviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import mx.linko.examenupax.databinding.DialogLoaderBinding

class LoaderDialog: DialogFragment()  {
    private lateinit var binding: DialogLoaderBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogLoaderBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onStart() {
        super.onStart()
        if (dialog != null) {

            dialog?.window?.setBackgroundDrawable(null)
            dialog?.setCancelable(false)

        }
    }
}