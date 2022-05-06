package ru.ds.gitapp.data.fake

import io.reactivex.rxjava3.core.Single
import ru.ds.gitapp.domain.GitHubEntity
import ru.ds.gitapp.domain.GitHubRep


class MockProjectsRepoImpl : GitHubRep {

    override fun getUsers(username: String): Single<List<GitHubEntity>> {
        val mockList = listOf(
            GitHubEntity("0", "!!!","https://github.com/images/error/octocat_happy.gif","login","url","_","_","_","_","_","_","_"),
            GitHubEntity("0", "!!!","https://github.com/images/error/octocat_happy.gif","login","url","_","_","_","_","_","_","_"),
            GitHubEntity("0", "!!!","https://github.com/images/error/octocat_happy.gif","login","url","_","_","_","_","_","_","_"),
            GitHubEntity("0", "!!!","https://github.com/images/error/octocat_happy.gif","login","url","_","_","_","_","_","_","_"),
            GitHubEntity("0", "!!!","https://github.com/images/error/octocat_happy.gif","login","url","_","_","_","_","_","_","_"),


        )
        return Single.just(mockList)

    }

    override fun getRepOfUser(username: String): Single<List<GitHubEntity>> {
        val mockList = listOf(
            GitHubEntity("0", "!!!","https://github.com/images/error/octocat_happy.gif","login","url","_","_","_","_","_","_","_"),
            GitHubEntity("0", "!!!","https://github.com/images/error/octocat_happy.gif","login","url","_","_","_","_","_","_","_"),
            GitHubEntity("0", "!!!","https://github.com/images/error/octocat_happy.gif","login","url","_","_","_","_","_","_","_"),
            GitHubEntity("0", "!!!","https://github.com/images/error/octocat_happy.gif","login","url","_","_","_","_","_","_","_"),
            GitHubEntity("0", "!!!","https://github.com/images/error/octocat_happy.gif","login","url","_","_","_","_","_","_","_"),

        )
        return Single.just(mockList)

    }
    }
