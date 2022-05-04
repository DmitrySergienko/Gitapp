package ru.ds.gitapp.data.local

interface UserLocalRepository {

fun getUserFromLocalStorage(): List<ProfileEntity>

}