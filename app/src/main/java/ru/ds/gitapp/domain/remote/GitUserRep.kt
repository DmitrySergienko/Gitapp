package ru.ds.gitapp.domain.remote
import io.reactivex.rxjava3.core.Single

interface GitUserRep {
    fun getUsers(username: String): Single<List<GitUserEntity>>
}