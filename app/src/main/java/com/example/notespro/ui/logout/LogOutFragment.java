package com.example.notespro.ui.logout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.notespro.MainActivity;
import com.example.notespro.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogOutFragment extends Fragment {

    private LogOutFragment binding;

    Button logOutButton;
    FirebaseAuth firebaseAuth =  FirebaseAuth.getInstance();

    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

    private static final String SHARED_PREF_NAME = "emailAndPassPref";

    private static final String KEY_EMAIL = "email";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View viewFragment = inflater.inflate(R.layout.fragment_log_out,container,false);

        logOutButton = viewFragment.findViewById(R.id.log_out_button_google);

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogOutGoogle(getView());
            }
        });

        return viewFragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void LogOutGoogle(View view) {

        firebaseAuth.signOut();

        SharedPreferences preferences = requireActivity().getSharedPreferences(SHARED_PREF_NAME, 0);
        preferences.edit().remove(KEY_EMAIL).apply();

        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        requireActivity().finish();
    }
}