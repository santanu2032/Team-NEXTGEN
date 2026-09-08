package com.localdatabase

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "importer_certificates")
data class TraderEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val iec_number: String,
    val certificate_number: String,
    val date_of_issue: String,
    val equipment: String,
    val date_of_validity: String
)
@Dao
interface TraderDao {
    @Query("SELECT * FROM importer_certificates")
    fun getAllTraders(): Flow<List<TraderEntity>>

    @Upsert
    suspend fun insertAll(traders: List<TraderEntity>)
}