package com.aycap.kisileruygulamasimvvm.di

import android.content.Context
import androidx.room.Room
import com.aycap.kisileruygulamasimvvm.data.repo.PersonsDaoRepository
import com.aycap.kisileruygulamasimvvm.room.Database
import com.aycap.kisileruygulamasimvvm.room.PersonsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePersonsDaoRepository(pdao:PersonsDao) : PersonsDaoRepository {
        return PersonsDaoRepository(pdao)
    }

    @Provides
    @Singleton
    fun providePersonsDao(@ApplicationContext context: Context) : PersonsDao{
        val db = Room.databaseBuilder(context,Database::class.java,"contacts.sqlite")
            .createFromAsset("contacts.sqlite").build()
        return db.getPeopleDao()
    }
}