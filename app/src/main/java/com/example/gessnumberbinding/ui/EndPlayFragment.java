package com.example.gessnumberbinding.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gessnumberbinding.R;
import com.example.gessnumberbinding.databinding.FragmentEndPlayBinding;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class EndPlayFragment extends Fragment {

    private FragmentEndPlayBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment.

       return inflater.inflate(R.layout.fragment_end_play, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();
        String resultado = getArguments().getString("resultado");
        Toast.makeText(getContext(), resultado,Toast.LENGTH_SHORT).show();
    }
}
