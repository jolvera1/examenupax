package mx.linko.examenupax

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import mx.linko.examenupax.dataBase.tablas.Pokemon
import mx.linko.examenupax.databinding.DialogDetailBinding

class DetailDialog(val pokemon: Pokemon): DialogFragment()  {
    private lateinit var binding: DialogDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogDetailBinding.inflate(inflater, container, false)
        binding.apply {
            item=pokemon
            if (!pokemon.img.isNullOrEmpty()) {
                ivResource.visibility = View.VISIBLE
                tvResource.visibility = View.GONE
                val uri = Uri.parse(pokemon.img)
                Glide.with(binding.root.context)
                    .load(uri)
                    .error(R.drawable.user)
                    .into(binding.ivResource)
            } else {
                ivResource.visibility = View.INVISIBLE
                tvResource.visibility = View.VISIBLE
                tvResource.text = pokemon.name
            }

        }
        return binding.root

    }
    override fun onStart() {
        super.onStart()
        if (dialog != null) {
            dialog?.window?.setBackgroundDrawable(null)
            dialog?.setCancelable(true)

        }
    }
}