package ru.ds.gitapp.data

import ru.ds.gitapp.R
import ru.ds.gitapp.domain.Profile

class UserRepositoryImp:UserRepository {

    override fun getUserFromLocalStorage(): List<Profile> {
        val userList = listOf(
            Profile("UserName1","email@example.com", R.drawable.ic_profile_icon1),
            Profile("UserName2","email@example.com", R.drawable.ic_profile_icon2),
            Profile("UserName3","email@example.com", R.drawable.ic_profile_icon3),
            Profile("UserName4","email@example.com", R.drawable.ic_profile_icon4),

            )
        return userList
    }

}