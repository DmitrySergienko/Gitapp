package ru.ds.gitapp.data

import ru.ds.gitapp.domain.Profile

interface UserRepository {

fun getUserFromLocalStorage(): List<Profile>
}