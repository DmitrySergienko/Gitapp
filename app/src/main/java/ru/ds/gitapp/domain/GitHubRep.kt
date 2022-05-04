package ru.ds.gitapp.domain
import io.reactivex.rxjava3.core.Single

interface GitHubRep {
    fun getUsers(username: String): Single<List<GitHubEntity>>
    fun getRepOfUser(username: String): Single<List<GitHubEntity>>
}