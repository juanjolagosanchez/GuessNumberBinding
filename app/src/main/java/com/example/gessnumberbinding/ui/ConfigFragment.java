package com.example.gessnumberbinding.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.gessnumberbinding.R;
import com.example.gessnumberbinding.data.Message;
import com.example.gessnumberbinding.databinding.FragmentConfigBinding;
import com.example.gessnumberbinding.databinding.FragmentPlayBinding;

public class ConfigFragment extends Fragment {

    private FragmentConfigBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        binding = FragmentConfigBinding.inflate(inflater, container, false);
        binding.setMessage(new Message());
        binding.btnPlay.setOnClickListener(view -> {
            if (binding.edAttempts.length() != 0 && binding.edPlayer.length() !=0){
                Bundle bundle= new Bundle();
                bundle.putString("message", String.valueOf(binding.edAttempts.getText()));
                NavHostFragment.findNavController(this).navigate(R.id.PlayFragment, bundle);
            }
            else{
                Toast.makeText(getContext(), "Los dos valores son obligatorios",Toast.LENGTH_SHORT).show();
            }

        });
        return binding.getRoot();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}