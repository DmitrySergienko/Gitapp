package ru.ds.gitapp.ui.gitusers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.ds.gitapp.domain.GitHubRep


class UserViewModelFactory(private val repo: GitHubRep) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(repo) as T
    }
}