package ru.ds.gitapp.data.local

interface LocalUserRepository {

fun getUserFromLocalStorage(): List<LocalUserEntity>

}