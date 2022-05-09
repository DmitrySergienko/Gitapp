package ru.ds.gitapp.ui.gitusers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import ru.ds.gitapp.domain.GitHubEntity
import ru.ds.gitapp.domain.GitHubRep

class UserViewModel(private val user: GitHubRep) : ViewModel() {
    private val _repo = MutableLiveData<List<GitHubEntity>>()
    val repo: LiveData<List<GitHubEntity>> = _repo

    private val _inProgerss = MutableLiveData<Boolean>()
    val inProgerss: LiveData<Boolean> = _inProgerss

    //для отписки
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    //метод - подписка на обновления с сервера
    fun onShowUserRepository(username: String) {
        _inProgerss.postValue(true) // устанавливаем progress Bar
        compositeDisposable
            .add(user
                .getRepOfUser(username)
                .subscribeBy {
                    _inProgerss.postValue(false) // убираем progress Bar
                    _repo.postValue(it)// как только приходит результат отправляем его
                }
            )
    }

    fun onShowRepository(username: String) {
        _inProgerss.postValue(true) // устанавливаем progress Bar
        compositeDisposable
            .add(user
                .getUsers(username)
                .subscribeBy {
                    _inProgerss.postValue(false) // убираем progress Bar
                    _repo.postValue(it)// как только приходит результат отправляем его
                }
            )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}