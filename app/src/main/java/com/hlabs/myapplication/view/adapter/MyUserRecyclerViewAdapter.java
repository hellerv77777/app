package com.hlabs.myapplication.view.adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hlabs.myapplication.R;
import com.hlabs.myapplication.models.UserEntity;

import java.util.List;


public class MyUserRecyclerViewAdapter extends RecyclerView.Adapter<MyUserRecyclerViewAdapter.ViewHolder> {

    private List<UserEntity> mValues;

    public MyUserRecyclerViewAdapter() {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textViewUserName.setText(new StringBuilder().append("Nombre: ").append(mValues.get(position).getName()));
        holder.textViewUserLastName.setText(new StringBuilder().append("Apellidos: ").append(mValues.get(position).getLastName()));
        holder.textViewUserStatus.setText(new StringBuilder().append("Estado: ").append(mValues.get(position).getStatus()));
    }

    @Override
    public int getItemCount() {
        return mValues==null?0:mValues.size();
    }

    public void updateItems(List<UserEntity> mValues) {
        this.mValues = mValues;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewUserName;
        public final TextView textViewUserLastName;
        public final TextView textViewUserStatus;
        public UserEntity mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewUserName = (TextView) view.findViewById(R.id.textViewUserName);
            textViewUserLastName = (TextView) view.findViewById(R.id.textViewUserLastName);
            textViewUserStatus = (TextView) view.findViewById(R.id.textViewUserStatus);
        }

    }
}