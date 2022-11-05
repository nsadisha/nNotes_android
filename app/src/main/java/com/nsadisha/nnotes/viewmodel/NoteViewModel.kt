package com.nsadisha.nnotes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.nsadisha.nnotes.model.Note
import com.nsadisha.nnotes.room.NotesDatabase
import com.nsadisha.nnotes.room.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application) {
    private var _noteList: LiveData<List<Note>>
    private val repository: NotesRepository

    init {
        //error happens at this line
        val db = NotesDatabase.getInstance(application)

        repository = NotesRepository(db.notesDao())
        _noteList = repository.readAllNotes
    }

    fun addNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.addNote(note)
    }
    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteNote(note)
    }
}