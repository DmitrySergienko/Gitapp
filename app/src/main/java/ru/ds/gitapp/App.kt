package ru.ds.gitapp

import android.app.Application
import androidx.fragment.app.Fragment
import ru.ds.gitapp.di.AppDependenciesComponent
import ru.ds.gitapp.di.DaggerAppDependenciesComponent


//создаем app для централизованного доступа к данным (чтобы не создавать реп в каждом актививи и фрагменте)

class App : Application() {
//создаем хранилище зависимостей AppDependenciesComponent
    lateinit var appDependenciesComponent: AppDependenciesComponent

    override fun onCreate() {
        super.onCreate()
            //создаем компонент
        appDependenciesComponent = DaggerAppDependenciesComponent.builder().build()

    }
}

val Fragment.app: App
    get() {
        return requireActivity().application as App
    }


/*
* //для активити
val Context.app: App
    get() = applicationContext as App

//для фрагмента
val Fragment.app: App
    get() = requireActivity().application as App
//get()= requireActivity().app*/