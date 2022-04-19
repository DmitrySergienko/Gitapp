package ru.ds.gitapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import ru.ds.gitapp.domain.GitUserRep
import ru.ds.gitapp.model.GitUserEntity

class GITRepositoryViewModel(private val gitUserRepo: GitUserRep) : ViewModel() {
    private val _repo = MutableLiveData<List<GitUserEntity>>()
    val repo: LiveData<List<GitUserEntity>> = _repo

    //для отписки
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    //метод - подписка на обновления с сервера
    fun onShowRepository(username: String) {
        compositeDisposable
            .add(gitUserRepo
                .getUsers(username)
                .subscribeBy { _repo.postValue(it)} // как только приходит результат отправляем его
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}