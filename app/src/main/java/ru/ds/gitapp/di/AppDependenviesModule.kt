package ru.ds.gitapp.di

import dagger.Component
import ru.ds.gitapp.ui.gitrepo.RepositoryFragment
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppDependeciesModule::class
    ]
)

//указываем куда мыб удем вставлять зависимости
interface AppDependenciesComponent{
    fun inject(repositoryFragment: RepositoryFragment)
}


