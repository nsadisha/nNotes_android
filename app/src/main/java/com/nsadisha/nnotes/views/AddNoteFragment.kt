package com.nsadisha.nnotes.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nsadisha.nnotes.R
import com.nsadisha.nnotes.databinding.FragmentAddNoteBinding
import com.nsadisha.nnotes.databinding.FragmentHomeBinding
import com.nsadisha.nnotes.model.Note
import com.nsadisha.nnotes.util.ToastManager
import com.nsadisha.nnotes.viewmodel.NoteViewModel

class AddNoteFragment : Fragment() {
    private lateinit var binding: FragmentAddNoteBinding
    private lateinit var viewModel: NoteViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add_note, container, false
        )
        binding.saveBtn.setOnClickListener {
            saveNoteToDatabase()
        }
        return binding.root
    }

    private fun saveNoteToDatabase(){
        val title = binding.titleEt.toString()
        val description = binding.descriptionEt.toString()
        val note = Note(0, title, description)
        viewModel.addNote(note)
        ToastManager.show(requireContext(), "Note added successfully!")
        findNavController().navigate(R.id.action_addNoteFragment_to_homeFragment)
    }
}