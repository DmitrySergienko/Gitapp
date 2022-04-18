package ru.ds.gitapp.domain

import ru.ds.gitapp.model.Profile

interface UserLocalRepository {

fun getUserFromLocalStorage(): List<Profile>

}