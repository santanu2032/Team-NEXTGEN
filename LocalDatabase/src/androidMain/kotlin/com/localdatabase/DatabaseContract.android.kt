package com.localdatabase
// shared/src/androidMain/kotlin/com/localdatabase/AppDatabase.android.kt
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

lateinit var appContext: Context // Pass your MainActivity context here during app launch

actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val dbFile = appContext.getDatabasePath("gov_certificates.db")

    return Room.databaseBuilder<AppDatabase>(appContext, dbFile.absolutePath)
        .createFromAsset("gov_certificates.db")
}