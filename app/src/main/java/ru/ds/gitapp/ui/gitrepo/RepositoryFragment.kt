package ru.ds.gitapp.ui.gitrepo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.ds.gitapp.app
import ru.ds.gitapp.databinding.RepositoryFragmentBinding
import ru.ds.gitapp.domain.GitHubEntity
import ru.ds.gitapp.domain.GitHubRep
import javax.inject.Inject


//для использования данного фрагмента в любом другом активити используя контракт необходимо
// наследоваться от Controller


class RepositoryFragment : Fragment() {
    private var _binding: RepositoryFragmentBinding? = null
    private val binding: RepositoryFragmentBinding
        get() = _binding!!


    //Dagger implementation
    @Inject
    lateinit var gitHubRep: GitHubRep

    private val viewModel: RepositoryViewModel by viewModels {

        ReposViewModelFactory(gitHubRep)
    }

    // тут прописываем агрумент itemClickCallback для адаптера
    // (слушатель нажатия элемента списка)
    private val adapter = RepositoryAdapter {
         //Toast.makeText(requireContext(), it.html_url, Toast.LENGTH_SHORT).show()
        controller.onShowUserDetails(it)

        /*  requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, UserFragment.newInstance(it))
                .addToBackStack("")
                .commit()
           */
    }

    //интерфейс для передачи данных из фрагмента в активити через контракт
    interface Controller {
        fun onShowUserDetails(user: GitHubEntity)
    }

    //метод для присоединения активити
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity !is Controller) throw
        IllegalThreadStateException("Activity должна наследоваться от GitUsersFragment.Controller\"")

    }

    private val controller by lazy { activity as Controller }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RepositoryFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Dagger
        //компонент appDependenciesComponent
        // в этой активити находит все @inject и генерирует для них зависимости

        app.appDependenciesComponent.inject(this) //dagger injection

        recyclerView() //отображение данных в recycler View
        initOutgoingEvents() //метод отправляет event
        initIncomingEvents() //метод получает event

    }

    private fun recyclerView() {
        binding.recycleView.layoutManager = LinearLayoutManager(requireContext())
        if(!adapter.hasObservers()){
            adapter.setHasStableIds(true)}

        binding.recycleView.adapter = adapter

    }

    private fun initIncomingEvents() {
        binding.buttonEnterText.setOnClickListener {
            val userData = binding.enterEditText.text.toString()
            viewModel.onShowUserRepository(userData)

        }

      val userData = ""
      viewModel.onShowRepository(userData)

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
        fun newInstance() = RepositoryFragment()
    }
}