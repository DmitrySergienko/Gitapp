package ru.ds.gitapp.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.ds.gitapp.app
import ru.ds.gitapp.databinding.UserListFragmentBinding


class ItemUserFragment : Fragment() {
    private var _binding: UserListFragmentBinding? = null
    private val binding: UserListFragmentBinding
        get() = _binding!!


    private val viewModel: UserRepositoryViewModel by viewModels {
        ReposUserViewModelFactory(
            requireActivity().app.gitUserRepo
        )
    }
    private val adapter = UserAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UserListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initOutgoingEvents() //метод отправляет event
        initIncomingEvents() //метод получает event
        recyclerView() //отображение данных в recycler View

    }

    private fun recyclerView() {
        binding.recycleUserView.layoutManager = LinearLayoutManager(requireContext())
        adapter.setHasStableIds(true)
        binding.recycleUserView.adapter = adapter

    }


    private fun initIncomingEvents() {

        binding.buttonEnterText.setOnClickListener {
            val userData = binding.enterEditText.text.toString()
            viewModel.onShowUserRepository(userData)
        }
    }

    private fun initOutgoingEvents() {
        viewModel.repo.observe(requireActivity()) {
            adapter.setData(it)
        }
        viewModel.inProgerss.observe(requireActivity()) {
            if (it) {
                binding.progressBarLayout.visibility = View.VISIBLE
            } else {
                binding.progressBarLayout.visibility = View.GONE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = ItemUserFragment()
    }
}