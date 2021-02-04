package com.hlabs.myapplication.viewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.hlabs.myapplication.models.UserEntity;
import com.hlabs.myapplication.db.FmsDataBase;
import com.hlabs.myapplication.db.UserDao;

import java.util.List;

public class UserRepository {

    private UserDao userDao;

    public UserRepository(Application application) {

        userDao = FmsDataBase.getInstance(application).getMenuDao();
    }

    public LiveData<List<UserEntity>> getListUsers(){ return userDao.getListUser(); }

    public void registerUser(UserEntity userEntity) {
        new InsertUserAsyncTask(userDao).execute(userEntity);
    }

    private static class InsertUserAsyncTask extends AsyncTask<UserEntity, Void, Void> {

        private UserDao userDao;

        public InsertUserAsyncTask(UserDao playerDao) {
            this.userDao = playerDao;
        }

        @Override
        protected Void doInBackground(UserEntity... players) {
            userDao.insertUser(players[0]);
            return null;
        }
    }
}
