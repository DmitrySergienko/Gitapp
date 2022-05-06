package ru.ds.gitapp.di


import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.ds.gitapp.data.retrofit.GitHubApi
import ru.ds.gitapp.data.retrofit.RetrofitRepositoryImpl
import ru.ds.gitapp.domain.GitHubRep
import javax.inject.Named
import javax.inject.Singleton



//Dagger
@Module //здесь указываем все модули (описания как создвать объекты)
class AppDependeciesModule {

    @Singleton
    @Provides
    fun providesGidHubApi(retrofit: Retrofit):GitHubApi{
        return retrofit.create(GitHubApi::class.java)
    }

@Singleton
    @Provides
    fun providesProjectRepo(api: GitHubApi): GitHubRep{
        return RetrofitRepositoryImpl(api)
    }

    @Provides
    fun providesConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Named("api_url")
    fun providesBaseURL(): String {
        return "https://api.github.com/"
    }

    @Provides
    @Named("username")
    fun providedefoultUserName(): String {
        return "dmitrysergienko"
    }

    @Singleton
    @Provides
    fun provideRetrofit(@Named("api_url")baseURL: String, converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(converterFactory)
            .build()
    }
}


