package ru.ds.gitapp.ui.local

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.ds.gitapp.data.local.LocalUserEntity
import ru.ds.gitapp.data.local.LocalUserRepositoryImp
import ru.ds.gitapp.databinding.LocalUserFragmentBinding



class LocalUserFragment : Fragment() {
    private var _binding: LocalUserFragmentBinding? = null
    private val binding: LocalUserFragmentBinding
        get() = _binding!!

    private var adapter: LocalUserAdapter? = null


   private val userLocalList = LocalUserRepositoryImp()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LocalUserFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.apply {

            val list = ArrayList<LocalUserEntity>()
            list.addAll(userLocalList.getUserFromLocalStorage())

            recycleView.hasFixedSize()
            recycleView.layoutManager = LinearLayoutManager(requireContext())
            adapter = LocalUserAdapter(list, requireContext())
            recycleView.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = LocalUserFragment()
    }
}