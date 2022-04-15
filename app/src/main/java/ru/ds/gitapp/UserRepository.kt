package ru.ds.gitapp

import ru.ds.gitapp.domain.Profile

interface UserRepository {

fun getUserFromLocalStorage(): List<Profile>
}