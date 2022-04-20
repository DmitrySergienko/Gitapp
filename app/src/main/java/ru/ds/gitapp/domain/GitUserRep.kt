package ru.ds.gitapp.domain
import io.reactivex.rxjava3.core.Single
import ru.ds.gitapp.model.GitUserEntity

interface GitUserRep {
    fun getUsers(username: String): Single<List<GitUserEntity>>
}