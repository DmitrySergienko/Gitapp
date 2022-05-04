package ru.ds.gitapp

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ds.gitapp.data.remote.GitUserRep
import ru.ds.gitapp.data.retrofit.GitHubApi
import ru.ds.gitapp.data.retrofit.RetrofitUsersRepoImpl
import ru.ds.gitapp.di.appModule

//создаем app для централизованного доступа к данным (чтобы не создавать реп в каждом актививи и фрагменте)

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)

        }
    }

 // private val baseUrl = "https://api.github.com/"
 // private val retrofit = Retrofit.Builder()
 //     .baseUrl(baseUrl)
 //     .addConverterFactory(GsonConverterFactory.create())
 //     .build()
 // private val gitHubApi: GitHubApi = retrofit.create(GitHubApi::class.java)
 // val gitUserRepo: GitUserRep by lazy { RetrofitUsersRepoImpl(gitHubApi) }
}

//для активити
val Context.app: App
    get() = applicationContext as App

//для фрагмента
val Fragment.app: App
    get() = requireActivity().application as App
//get()= requireActivity().app