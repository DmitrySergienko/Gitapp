package ru.ds.gitapp.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import ru.ds.gitapp.data.remote.GitUserEntity
import ru.ds.gitapp.data.remote.GitUserRep

class UserRepositoryViewModel(private val gitUserRep: GitUserRep) : ViewModel() {
    private val _repo = MutableLiveData<List<GitUserEntity>>()
    val repo: LiveData<List<GitUserEntity>> = _repo

    private val _inProgerss = MutableLiveData<Boolean>()
    val inProgerss: LiveData<Boolean> = _inProgerss

    //для отписки
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    //метод - подписка на обновления с сервера
    fun onShowUserRepository(username: String) {
        _inProgerss.postValue(true) // устанавливаем progress Bar
        compositeDisposable
            .add(gitUserRep
                .getUsersRep(username)
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