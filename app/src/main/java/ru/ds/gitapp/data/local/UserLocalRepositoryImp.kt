package ru.ds.gitapp.data.local

import ru.ds.gitapp.R

class UserLocalRepositoryImp: UserLocalRepository {

    override fun getUserFromLocalStorage(): List<ProfileEntity> {
        val userList = listOf(
            ProfileEntity("UserName1","email@example.com", R.drawable.ic_profile_icon1,"https://avatars.githubusercontent.com/u/2?v=4"),
            ProfileEntity("UserName2","email@example.com", R.drawable.ic_profile_icon2, "https://avatars.githubusercontent.com/u/2?v=4"),
            ProfileEntity("UserName3","email@example.com", R.drawable.ic_profile_icon3, "https://avatars.githubusercontent.com/u/2?v=4"),
            ProfileEntity("UserName4","email@example.com", R.drawable.ic_profile_icon4,"https://avatars.githubusercontent.com/u/2?v=4"),
            )
        return userList
    }


}