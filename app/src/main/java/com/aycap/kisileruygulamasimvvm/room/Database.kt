package com.aycap.kisileruygulamasimvvm.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aycap.kisileruygulamasimvvm.data.entity.Persons

@Database(entities = [Persons::class], version = 1)
abstract class Database : RoomDatabase(){
    abstract fun getPeopleDao() : PersonsDao
}