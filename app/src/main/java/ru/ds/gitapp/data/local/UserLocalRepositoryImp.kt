package ru.ds.gitapp.data.local

import ru.ds.gitapp.R

class UserLocalRepositoryImp: UserLocalRepository {

    override fun getUserFromLocalStorage(): List<ProfileEntity> {
        val userList = listOf(
            ProfileEntity("UserName1","email@example.com", R.drawable.ic_profile_icon1),
            ProfileEntity("UserName2","email@example.com", R.drawable.ic_profile_icon2),
            ProfileEntity("UserName3","email@example.com", R.drawable.ic_profile_icon3),
            ProfileEntity("UserName4","email@example.com", R.drawable.ic_profile_icon4),

            )
        return userList
    }


}