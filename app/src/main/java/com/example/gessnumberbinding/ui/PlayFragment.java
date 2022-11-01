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
import com.example.gessnumberbinding.databinding.FragmentPlayBinding;

import java.util.IllegalFormatCodePointException;
import java.util.Random;

public class PlayFragment extends Fragment {

    private FragmentPlayBinding binding;
    int counter = 1;
    int result;
    Random rnd = new Random();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        int min =1;
        int max= 100;
        result = rnd.nextInt(max)+min;
        binding = FragmentPlayBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String attemptsS = getArguments().getString("message");
                int attempts = Integer.parseInt(attemptsS);

                if (binding.edNumber.length()==0)
                {
                    Toast.makeText(getActivity(),"Es obligatorio poner un numero", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (counter <=attempts) {

                        String UserGessingS = binding.edNumber.getText().toString();
                        int UserGessing = Integer.parseInt(UserGessingS);

                        if (UserGessing > result) {
                            counter++;
                            binding.tvResult.setText(getResources().getString(R.string.LowerNumber));

                        }

                        else if (UserGessing < result) {
                            counter++;
                            binding.tvResult.setText(getResources().getString(R.string.higherNumber));

                        } else {
                            senResultWin();

                        }
                    }
                    else{
                        senResultLose();
                    }
                }

            }
        });

        binding.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edNumber.setText("");
                binding.tvResult.setText("");
                counter = 1;
                binding.btnTest.setEnabled(true);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void senResultWin(){

       Bundle bundle = new Bundle();
       bundle.putString("resultado", "has ganado");
        NavHostFragment.findNavController(this).navigate(R.id.endPlayFragment, bundle);

    }

    private void senResultLose(){
        Bundle bundle = new Bundle();
        bundle.putString("resultado", "has perdido");
        NavHostFragment.findNavController(this).navigate(R.id.endPlayFragment, bundle);
    }

/**
 *                 NavHostFragment.findNavController(PlayFragment.this)
 *                         .navigate(R.id.action_PlayFragment_to_ConfigFragment);
 */

}