package mx.linko.examenupax.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mx.linko.examenupax.R
import mx.linko.examenupax.dataBase.tablas.Pokemon
import mx.linko.examenupax.databinding.ItemPokemonBinding


class Adapter(
    var list: MutableList<Pokemon>,
    val listener: (Pokemon) -> Unit
) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPokemonBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(listener, list[position])

    override fun getItemCount(): Int = list.size


    class ViewHolder(val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            listener: (Pokemon) -> Unit,
            pokemon: Pokemon
        ) {
            binding.apply {
                item = pokemon
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
                cvLeccion.setOnClickListener {
                    listener(pokemon)
                }
            }
        }
    }
}