package com.hlabs.myapplication.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.hlabs.myapplication.models.UserEntity;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private LiveData<List<UserEntity>> getListUsers;
    private UserRepository userRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);

        userRepository = new UserRepository(application);
    }

    public LiveData<List<UserEntity>> getListUsers(){ return  userRepository.getListUsers(); }


    public void registerUser(UserEntity userEntity) {

        userRepository.registerUser(userEntity);
    }
}
