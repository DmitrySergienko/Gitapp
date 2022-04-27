package ru.ds.gitapp.data.remote
import io.reactivex.rxjava3.core.Single

interface GitUserRep {
    fun getUsers(username: String): Single<List<GitUserEntity>>
    fun getUsersRep(username: String): Single<List<GitUserEntity>>
}