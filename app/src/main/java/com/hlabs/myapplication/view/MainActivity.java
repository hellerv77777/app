package com.hlabs.myapplication.view;

import android.content.Intent;
import android.os.Bundle;

import com.hlabs.myapplication.models.UserEntity;
import com.hlabs.myapplication.view.adapter.MyUserRecyclerViewAdapter;
import com.hlabs.myapplication.R;
import com.hlabs.myapplication.databinding.ActivityMainBinding;
import com.hlabs.myapplication.viewModel.UserViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private UserViewModel mViewModel;
    private MyUserRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        mViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        setContentView(binding.getRoot());


        binding.buttonRegistrar.setOnClickListener(view -> {

           Intent intent = new Intent(MainActivity.this,RegistroActivity.class);
           startActivity(intent);

        });


        binding.recyclerViewUsuarios.setHasFixedSize(true);
        binding.recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(this));



        mAdapter = new MyUserRecyclerViewAdapter();

        binding.recyclerViewUsuarios.setAdapter(mAdapter);


        mViewModel.getListUsers().observe(MainActivity.this, userEntities -> {

            mAdapter.updateItems(userEntities);
            mAdapter.notifyDataSetChanged();

        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

    }
}