package com.test.rahmasameh.pure.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.test.rahmasameh.R;
import com.test.rahmasameh.mvvm.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    List<UserDTO> list = new ArrayList<>();

    public UsersAdapter(List<UserDTO> userDTOS) {
        this.list = userDTOS;

    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent, false);
        return new UserViewHolder(view);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserDTO userDTO = list.get(position);
        if (userDTO.getFirstName() != null && userDTO.getLastName() != null) {
            holder.user_name.setText(userDTO.getFirstName() + " " + userDTO.getLastName());
        }
        if (userDTO.getAvatar() != null) {
            Glide.with(holder.profile_image.getContext()).load(userDTO.getAvatar()).into(holder.profile_image);
        }


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        CircleImageView profile_image;
        TextView user_name;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            profile_image = itemView.findViewById(R.id.profile_image);
            user_name = itemView.findViewById(R.id.user_name);


        }
    }
}
