package ru.ds.gitapp.ui.gitrepo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.ds.gitapp.data.remote.GitUserRep


class ReposViewModelFactory(private val repo: GitUserRep) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GITRepositoryViewModel(repo) as T
    }
}