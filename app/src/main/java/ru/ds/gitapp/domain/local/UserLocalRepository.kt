package ru.ds.gitapp.domain.local

interface UserLocalRepository {

fun getUserFromLocalStorage(): List<Profile>

}