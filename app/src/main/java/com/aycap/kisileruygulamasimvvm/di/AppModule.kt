package com.aycap.kisileruygulamasimvvm.di

import com.aycap.kisileruygulamasimvvm.data.repo.PersonsDaoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePersonsDaoRepository() : PersonsDaoRepository {
        return PersonsDaoRepository()
    }
}