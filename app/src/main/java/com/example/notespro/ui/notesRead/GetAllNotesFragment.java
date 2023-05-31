package com.example.notespro.ui.notesRead;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notespro.NoteAdapter;
import com.example.notespro.R;
import com.example.notespro.model.Note;
import com.example.notespro.utility.Utility;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;

public class GetAllNotesFragment extends Fragment {

    private static final Utility utility = new Utility();

    RecyclerView recyclerView;

    NoteAdapter noteAdapter;



    public static GetAllNotesFragment newInstance() {
        return new GetAllNotesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View viewFragment =  inflater.inflate(R.layout.fragment_get_all_notes, container, false);

        recyclerView = viewFragment.findViewById(R.id.recycler_view);

//        setUpRecyclerView();

        // TO DO: get all notes
        return viewFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view);
        setUpRecyclerView();
    }

    void setUpRecyclerView (){
        Query query = Utility.getCollectionReferenceForNotes();
        FirestoreRecyclerOptions<Note> options = new FirestoreRecyclerOptions.Builder<Note>()
                .setQuery(query, Note.class).build();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        noteAdapter = new NoteAdapter(options,getContext());
        recyclerView.setAdapter(noteAdapter);
        noteAdapter.notifyDataSetChanged();
    }

    //    @Override
//    public void onStart() {
//        super.onStart();
//        noteAdapter.startListening();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        noteAdapter.stopListening();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        noteAdapter.notifyDataSetChanged();
//    }

}