package com.localdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

@Database(entities = [TraderEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun traderDao(): TraderDao
}

// Contract for platform-specific file locations
expect fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>

// The shared initialization function
fun getRoomDatabase(): AppDatabase {
    return getDatabaseBuilder()
        .setDriver(BundledSQLiteDriver()) // Connects the KMP SQLite driver
        .build()
}