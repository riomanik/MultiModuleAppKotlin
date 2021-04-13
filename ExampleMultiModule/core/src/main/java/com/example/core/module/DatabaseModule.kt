package com.example.core.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class DatabaseModule() {

    @Singleton
    @Provides
    fun provideRoomDatabase(
        context: Context,
        @Named("APP_DATABASE_NAME") databaseName: String
    ): RoomDatabase {
        return Room.databaseBuilder(context, RoomDatabase::class.java, databaseName)
            .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
            .fallbackToDestructiveMigrationOnDowngrade()
            .build()
    }
}