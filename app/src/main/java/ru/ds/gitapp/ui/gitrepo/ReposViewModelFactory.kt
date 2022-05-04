package ru.ds.gitapp.ui.gitrepo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.ds.gitapp.domain.GitHubRep


class ReposViewModelFactory(private val repo: GitHubRep) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RepositoryViewModel(repo) as T
    }
}