package com.example.loginfeature.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.loginfeature.BuildConfig
import com.example.loginfeature.data.migration.MigrationFirst
import com.example.loginfeature.domain.Login

@Database(
        entities = [
            Login::class
        ],
        version = BuildConfig.DATABASE_VERSION
)

abstract class DatabaseLogin : RoomDatabase() {
    abstract fun loginDao(): LoginDao

    companion object {
        @Volatile
        private var instance: DatabaseLogin? = null

        fun getInstance(context: Context, databaseName: String): DatabaseLogin {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(context, databaseName).also {
                        instance = it }
            }
        }

        private fun buildDatabase(context: Context, databaseName: String): DatabaseLogin {
            return Room.databaseBuilder(context, DatabaseLogin::class.java, databaseName)
                .setJournalMode(JournalMode.TRUNCATE)
                .fallbackToDestructiveMigrationOnDowngrade()
                .addMigrations(
                    MigrationFirst()
                )
                .build()
        }
    }
}
