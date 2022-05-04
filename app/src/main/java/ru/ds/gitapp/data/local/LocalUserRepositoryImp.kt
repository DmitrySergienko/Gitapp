package ru.ds.gitapp.data.local

import ru.ds.gitapp.R

class LocalUserRepositoryImp: LocalUserRepository {

    override fun getUserFromLocalStorage(): List<LocalUserEntity> {
        val userList = listOf(
            LocalUserEntity("UserName1","email@example.com", R.drawable.ic_profile_icon1,"https://avatars.githubusercontent.com/u/4?v=4"),
            LocalUserEntity("UserName2","email@example.com", R.drawable.ic_profile_icon2, "https://avatars.githubusercontent.com/u/4?v=4"),
            LocalUserEntity("UserName3","email@example.com", R.drawable.ic_profile_icon3, "https://avatars.githubusercontent.com/u/4?v=4"),
            LocalUserEntity("UserName4","email@example.com", R.drawable.ic_profile_icon4,"https://avatars.githubusercontent.com/u/4?v=4"),
            )
        return userList
    }



}