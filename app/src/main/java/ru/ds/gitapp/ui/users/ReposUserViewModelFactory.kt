package ru.ds.gitapp.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.ds.gitapp.data.remote.GitUserRep


class ReposUserViewModelFactory(private val repo: GitUserRep) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserRepositoryViewModel(repo) as T
    }
}