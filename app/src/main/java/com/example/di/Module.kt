package com.example.di

import com.example.data.DataModelRepositoryImpl
import com.example.domain.interactors.GetDemoTestUseCase
import com.example.domain.repo.DataConfigRepository
import com.example.myapplication.ui.DemoViewModel
import com.example.network.RepoAPI
import com.example.network.ServiceBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repoModule = module {
    single<DataConfigRepository> { DataModelRepositoryImpl(get()) }
}

val serviceModule = module {
    single {
        ServiceBuilder.buildService(RepoAPI::class.java)
    }
}

val useCaseModule = module {
    factory { GetDemoTestUseCase(get()) }
}

val viewModule11 = module {
    viewModel {
        DemoViewModel(get())
    }
}