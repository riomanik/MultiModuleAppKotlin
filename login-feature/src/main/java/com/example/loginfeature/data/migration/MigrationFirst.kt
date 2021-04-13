package com.example.loginfeature.data.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.core_entity.login.Login

class MigrationFirst : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            """CREATE TABLE IF NOT EXISTS ${com.example.core_entity.login.Login.TABLE_NAME} (
                    ${com.example.core_entity.login.Login.COLUMN_USER_ID} INTEGER NOT NULL,
                    ${com.example.core_entity.login.Login.COLUMN_USERNAME} TEXT NOT NULL,
                    PRIMARY KEY(${com.example.core_entity.login.Login.COLUMN_USER_ID})
                    )"""
        )
    }
}
