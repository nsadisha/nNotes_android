package com.nsadisha.nnotes.room

import androidx.lifecycle.LiveData
import com.nsadisha.nnotes.model.Note

class NotesRepository(private val noteDao: NoteDao) {
    val readAllNotes: LiveData<List<Note>> = noteDao.getAll()

    suspend fun addNote(note: Note){
        noteDao.insert(note)
    }

    suspend fun deleteNote(note: Note){
        noteDao.delete(note)
    }
}