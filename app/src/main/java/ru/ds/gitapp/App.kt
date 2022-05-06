package ru.ds.gitapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.ds.gitapp.di.AppDependenciesComponent
import ru.ds.gitapp.di.DaggerAppDependenciesComponent
import ru.ds.gitapp.di.appModule

//создаем app для централизованного доступа к данным (чтобы не создавать реп в каждом актививи и фрагменте)

class App : Application() {

    lateinit var appDependenciesComponent: AppDependenciesComponent

    override fun onCreate() {
        super.onCreate()
      // startKoin {
      //     androidLogger()
      //     androidContext(this@App)
      //     modules(appModule)

       // }
appDependenciesComponent = DaggerAppDependenciesComponent.builder().build()

    }

}
