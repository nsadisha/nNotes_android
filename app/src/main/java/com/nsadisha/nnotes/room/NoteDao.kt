package com.nsadisha.nnotes.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nsadisha.nnotes.model.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes_table")
    fun getAll(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)
}