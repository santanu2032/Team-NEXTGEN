package com.localdatabase

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import java.io.File

actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val dbFile = java.io.File("gov_certificates.db")
    println("Room DB path: ${dbFile.absolutePath}")
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile.absolutePath
    )


}