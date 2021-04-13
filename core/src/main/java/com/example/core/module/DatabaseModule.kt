package com.example.core.module

import android.content.Context
import androidx.room.Room
import com.example.core.BuildConfig
import com.example.core.RoomDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule() {

    @Singleton
    @Provides
    fun provideRoomDatabase(
        context: Context
    ): RoomDatabase {
        return Room.databaseBuilder(context, RoomDatabase::class.java, BuildConfig.DATABASE_NAME)
            .setJournalMode(androidx.room.RoomDatabase.JournalMode.TRUNCATE)
            .fallbackToDestructiveMigrationOnDowngrade()
            .build()
    }
}