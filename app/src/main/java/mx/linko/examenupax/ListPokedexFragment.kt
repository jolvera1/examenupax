package mx.linko.examenupax

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.olvera.siruacademia.Base.BaseFragment
import mx.linko.examenupax.adapters.Adapter
import mx.linko.examenupax.customviews.LoaderDialog
import mx.linko.examenupax.dataBase.PokemonLap
import mx.linko.examenupax.dataBase.tablas.Pokemon
import mx.linko.examenupax.databinding.ListFragmentBinding
import mx.linko.examenupax.repository.Repository
import mx.linko.examenupax.viewModel.ViewModel

class ListPokedexFragment : BaseFragment() {

    lateinit var binding: ListFragmentBinding
    lateinit var viewmodel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListFragmentBinding.inflate(inflater, container, false)
        viewmodel = ViewModel(Repository(requireContext()))
        loader = LoaderDialog()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        initView()

    }

    fun initObservers() {
        viewmodel.offset.observe(viewLifecycleOwner) { o ->
            showingLoader(false)
            viewmodel.getBase(o)


        }
        viewmodel.list.observe(viewLifecycleOwner) { list ->
            if (!list.isNullOrEmpty()){
                binding.apply {
                    rv.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = Adapter(list as MutableList<Pokemon>) {
                            val dialog=DetailDialog(it)
                            dialog.show(requireActivity().supportFragmentManager, "")
                            dialog.isCancelable=true

                        }
                    }
                }
            }else{
                viewmodel.getAllPokemon(25)
                showingLoader(true)

            }


        }
        viewmodel.error.observe(viewLifecycleOwner) { e ->
            showingLoader(false)


        }

    }

    fun initView() {
        viewmodel.getBase(25)
        binding.apply {


        }

    }
}