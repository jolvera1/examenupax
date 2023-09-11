package mx.linko.examenupax

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.olvera.siruacademia.Base.BaseFragment
import mx.linko.examenupax.repository.Repository
import mx.linko.examenupax.customviews.LoaderDialog
import mx.linko.examenupax.databinding.ListFragmentBinding
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

        viewmodel.error.observe(viewLifecycleOwner) { e ->
            showingLoader(false)


        }

    }

    fun initView() {
        binding.apply {


        }


    }

}