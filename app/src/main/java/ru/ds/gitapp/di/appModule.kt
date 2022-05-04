package ru.ds.gitapp.di


import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.ds.gitapp.data.retrofit.GitHubApi
import ru.ds.gitapp.data.retrofit.RetrofitRepositoryImpl
import ru.ds.gitapp.domain.GitHubRep
import ru.ds.gitapp.ui.gitrepo.RepositoryViewModel
import ru.ds.gitapp.ui.gitusers.UserViewModel

// переменная типа module в которой описанны встроенные модули
// в фигурных скобках указываем создание объекта
// single - в единственном экземпляре
// factory - каждый раз новый

val appModule = module {

    single(named("api_url")) { "https://api.github.com/" }
    single<GitHubRep> { RetrofitRepositoryImpl(get()) }
    single<GitHubApi> { get<Retrofit>().create(GitHubApi::class.java) }
    single {
        Retrofit.Builder()
            .baseUrl(get<String>(named("api_url")))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(get())
            .build()
    }
    factory<Converter.Factory> { GsonConverterFactory.create() }

    viewModel { RepositoryViewModel(get()) }
    viewModel { UserViewModel(get()) }
}


