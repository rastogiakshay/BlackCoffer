package com.example.blackcoffer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FolderFragment extends Fragment {
    private String set_frag_text;
    public FolderFragment(String set_frag_text) {
        this.set_frag_text = set_frag_text  ;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_folder,container,false);
       TextView textView_set_frag_text = view.findViewById(R.id.frag_text);
        textView_set_frag_text.setText(set_frag_text);
        return view;
    }
}
