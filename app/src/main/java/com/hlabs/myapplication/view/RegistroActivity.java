package com.hlabs.myapplication.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.hlabs.myapplication.R;
import com.hlabs.myapplication.models.UserEntity;
import com.hlabs.myapplication.databinding.ActivityRegistroBinding;
import com.hlabs.myapplication.viewModel.UserViewModel;

public class RegistroActivity extends AppCompatActivity {

    private ActivityRegistroBinding binding;
    private UserViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();


        binding.buttonSave.setOnClickListener(view -> {

            if(binding.editTextName.getText().toString().isEmpty() ||
                    binding.editTextLastName.getText().toString().isEmpty() || binding.editTextStatus.getText().toString().isEmpty()){


                Toast.makeText(RegistroActivity.this, "No dejes espacios en blanco", Toast.LENGTH_SHORT).show();
                return;
            }

            UserEntity userEntity = new UserEntity(binding.editTextName.getText().toString(),
                    binding.editTextLastName.getText().toString(),
                    Integer.parseInt(binding.editTextStatus.getText().toString())
            );

            mViewModel.registerUser(userEntity);

            AlertDialog.Builder builder = new AlertDialog.Builder(RegistroActivity.this);
            builder.setTitle(R.string.app_name).setMessage(R.string.msg)
                    .setPositiveButton(R.string.new_re,null).setNegativeButton(R.string.salir, (dialogInterface, i) -> {

                        startActivity(new Intent(RegistroActivity.this,MainActivity.class));
                        finish();
                    }
            ).create().show();
        });
    }
}