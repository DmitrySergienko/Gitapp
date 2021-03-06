package ru.ds.gitapp.ui.gitusers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import ru.ds.gitapp.app
import ru.ds.gitapp.databinding.UserListFragmentBinding
import ru.ds.gitapp.domain.GitHubEntity
import ru.ds.gitapp.domain.GitHubRep
import javax.inject.Inject


class UserFragment : Fragment() {
    private var _binding: UserListFragmentBinding? = null
    private val binding: UserListFragmentBinding
        get() = _binding!!

    companion object {
        private const val GIT_DATA_KEY = "GIT_DATA_KEY"

        @JvmStatic
        fun newInstance(gitHubEntity: GitHubEntity): UserFragment {

            //сохраняем аргументы фрагмента в arguments
            val fragment = UserFragment()
            val args = Bundle()
            args.putParcelable(GIT_DATA_KEY, gitHubEntity)
            fragment.arguments = args
            return fragment
        }
    }

    //метод для получения аргумента
    fun getDataFromArguments(): GitHubEntity {
        return arguments?.getParcelable(GIT_DATA_KEY)
            ?: throw IllegalStateException("No argument Name")
    }

    //Dagger implementation
    @Inject
    lateinit var gitHubRep: GitHubRep

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Dagger
        //компонент appDependenciesComponent
        // в этой активити находит все @inject и генерирует для них зависимости

        app.appDependenciesComponent.inject(this) //dagger injection

        initData() //заполняем данными user_list_fragment
        initOutgoingEvents() //метод отправляет event
        initIncomingEvents() //метод получает event
        recyclerView() //отображение данных в recycler View

    }

    private fun initData() {
        var gitName = getDataFromArguments()
        binding.enterEditText.setText(gitName.login)
        binding.imageView.load(gitName.avatarUrl)
        binding.userLogin.text = "LOGIN: ${gitName.login}"
        binding.userId.text = "ID: ${gitName.id}"

    }

    private val viewModel: UserViewModel by viewModels {
        UserViewModelFactory(gitHubRep)
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

    private fun recyclerView() {
        binding.recycleUserView.layoutManager = LinearLayoutManager(requireContext())
        adapter.setHasStableIds(true)
        binding.recycleUserView.adapter = adapter

    }


    private fun initIncomingEvents() {
        val userData = binding.enterEditText.text.toString()
        viewModel.onShowUserRepository(userData)

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


}