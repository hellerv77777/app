package com.hlabs.myapplication.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.hlabs.myapplication.models.UserEntity;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertUser (UserEntity userEntity);

    @Query("SELECT * FROM users")
    LiveData<List<UserEntity>> getListUser();

}
