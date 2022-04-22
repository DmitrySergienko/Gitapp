package ru.ds.gitapp.domain
import io.reactivex.rxjava3.core.Single
import ru.ds.gitapp.model.User

interface GitUserRep {
    fun getUsers(): Single<List<User>>
}