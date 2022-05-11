package ru.ds.gitapp.di

import dagger.Component
import ru.ds.gitapp.ui.gitrepo.RepositoryFragment
import ru.ds.gitapp.ui.gitusers.UserFragment
import javax.inject.Named
import javax.inject.Singleton

 @Singleton
@Component(
    modules = [
        //здесь указываем все модули (описания как создвать объекты)
        AppDependeciesModule::class
    ]
)

//в хранилище зависимостей указываем куда мы будем вставлять зависимости
interface AppDependenciesComponent{
    fun inject(repositoryFragment: RepositoryFragment)
    fun inject(userFragment: UserFragment)

//указываем какие зависимости мы можем получить
    @Named("username")
    fun getDefaultUserName(): String
}


