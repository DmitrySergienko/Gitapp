package ru.ds.gitapp.data

import io.reactivex.rxjava3.core.Single
import ru.ds.gitapp.data.remote.GitUserEntity
import ru.ds.gitapp.data.remote.GitUserRep


class MockProjectsRepoImpl : GitUserRep {

    override fun getUsers(username: String): Single<List<GitUserEntity>> {
        val mockList = listOf(
            GitUserEntity("0", "!!!","https://github.com/images/error/octocat_happy.gif"),
            GitUserEntity("0", "!!!","https://github.com/images/error/octocat_happy.gif"),
            GitUserEntity("0", "!!!","https://github.com/images/error/octocat_happy.gif"),
            GitUserEntity("0", "!!!","https://github.com/images/error/octocat_happy.gif"),
            GitUserEntity("0", "!!!","https://github.com/images/error/octocat_happy.gif"),
        )
        return Single.just(mockList)

    }
}