package com.example.loginfeature.data.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.core_entity.login.Login

class MigrationFirst : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            """CREATE TABLE IF NOT EXISTS ${Login.TABLE_NAME} (
                    ${Login.COLUMN_USER_ID} INTEGER NOT NULL,
                    ${Login.COLUMN_USERNAME} TEXT NOT NULL,
                    PRIMARY KEY(${Login.COLUMN_USER_ID})
                    )"""
        )
    }
}
