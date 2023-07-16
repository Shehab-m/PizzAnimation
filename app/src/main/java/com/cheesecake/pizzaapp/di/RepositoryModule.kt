package com.cheesecake.pizzaapp.di

import com.cheesecake.pizzaapp.repository.PizzaRepository
import com.cheesecake.pizzaapp.repository.PizzaRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(repository: PizzaRepositoryImpl): PizzaRepository

}
