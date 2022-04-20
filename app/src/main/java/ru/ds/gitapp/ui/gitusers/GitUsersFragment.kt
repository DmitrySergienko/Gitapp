package ru.ds.gitapp.ui.gitusers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.ds.gitapp.app
import ru.ds.gitapp.databinding.AboutFragmentBinding
import ru.ds.gitapp.viewModel.GITRepositoryViewModel


class AboutFragment : Fragment() {
    private var _binding: AboutFragmentBinding? = null
    private val binding: AboutFragmentBinding
        get() = _binding!!

    private val viewModel: GITRepositoryViewModel by viewModels { ReposViewModelFactory(requireActivity().app.gitUserRepo) }
    private val adapter = GitAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AboutFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initOutgoingEvents() //метод отправляет event
        initIncomingEvents() //метод получает event
        recyclerView() //отображение данных в recycler View

    }

    private fun recyclerView() {
        binding.recycleView.layoutManager = LinearLayoutManager(requireContext())
        adapter.setHasStableIds(true)
        binding.recycleView.adapter = adapter

    }


    private fun initIncomingEvents() {
        binding.buttonEnterText.setOnClickListener {
            val userData = binding.enterEditText.text.toString()
            viewModel.onShowRepository(userData)
        }
    }

    private fun initOutgoingEvents() {
        viewModel.repo.observe(requireActivity()){
           adapter.setData(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = AboutFragment()
    }
}