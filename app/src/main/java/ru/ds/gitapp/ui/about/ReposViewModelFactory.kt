package ru.ds.gitapp.ui.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.ds.gitapp.domain.GitUserRep
import ru.ds.gitapp.viewModel.GITRepositoryViewModel


class ReposViewModelFactory(private val repo: GitUserRep) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GITRepositoryViewModel(repo) as T
    }
}