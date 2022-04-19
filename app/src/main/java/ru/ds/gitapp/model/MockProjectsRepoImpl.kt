package ru.ds.gitapp.model

import io.reactivex.rxjava3.core.Single
import ru.ds.gitapp.domain.GitUserRep

class MockProjectsRepoImpl : GitUserRep {

    override fun getUsers(userName: String): Single<List<GitUserEntity>> {
        val mockList = listOf(
            GitUserEntity("0", "!!!"),
            GitUserEntity("0", "!!!"),
            GitUserEntity("0", "!!!"),
            GitUserEntity("0", "!!!"),
            GitUserEntity("0", "!!!"),
        )
        return Single.just(mockList)

    }
}