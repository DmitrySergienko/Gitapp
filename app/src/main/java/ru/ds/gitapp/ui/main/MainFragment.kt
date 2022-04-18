package ru.ds.gitapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.ds.gitapp.databinding.MainFragmentBinding
import ru.ds.gitapp.domain.UserLocalRepositoryImp
import ru.ds.gitapp.model.Profile


class MainFragment : Fragment() {
    private var _binding: MainFragmentBinding? = null
    private val binding: MainFragmentBinding
        get() = _binding!!

    private var adapter: ProfileAdapter? = null


   private val userLocalList = UserLocalRepositoryImp()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.apply {

            val list = ArrayList<Profile>()
            list.addAll(userLocalList.getUserFromLocalStorage())

            recycleView.hasFixedSize()
            recycleView.layoutManager = LinearLayoutManager(requireContext())
            adapter = ProfileAdapter(list, requireContext())
            recycleView.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}