package com.example.notespro.ui.notesUpdate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.notespro.ProfileActivity;
import com.example.notespro.R;
import com.example.notespro.model.Note;
import com.example.notespro.utility.Utility;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.DocumentReference;





public class AddNoteFragment extends Fragment {

    private static final Utility utility = new Utility();

    EditText titleEditText, contentEditText;

    ImageButton saveNoteBtn;

    public static AddNoteFragment newInstance() {
        return new AddNoteFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View viewFragment = inflater.inflate(R.layout.fragment_add_note, container, false);

        titleEditText = viewFragment.findViewById(R.id.notes_title_text);
        contentEditText = viewFragment.findViewById(R.id.notes_content_text);
        saveNoteBtn = viewFragment.findViewById(R.id.save_note_btn);

        saveNoteBtn.setOnClickListener((v)-> saveNote());

        return viewFragment;
    }
    void saveNote(){
        String noteTitle = titleEditText.getText().toString();
        String noteContent = contentEditText.getText().toString();

        if(noteTitle.isEmpty()){
            titleEditText.setError("Title is required");
            return;
        }



        Note note = new Note();
        note.setTitle(noteTitle);
        note.setContent(noteContent);

        saveNoteToFireBase(note);
    }

    void saveNoteToFireBase(Note note){
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForNotes().document();

        documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Utility.showToast(getActivity(),"Note added successfully.");
                    Intent intent = new Intent(getActivity(), ProfileActivity.class);
                    startActivity(intent);
                } else {
                    Utility.showToast(getActivity(),":((((");
                }
            }
        });
    }

}