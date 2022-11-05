package com.nsadisha.nnotes.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String
)
