package com.test.rahmasameh.mvvm_kotlin.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.test.rahmasameh.R
import android.annotation.SuppressLint
import android.view.View
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import android.widget.TextView
import com.test.rahmasameh.mvvm_kotlin.model.UserDTO
import java.util.ArrayList

class UsersAdapter(  val list: List<UserDTO>) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapter.UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_user, parent, false)
        return UserViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val userDTO = list[position]
        holder.user_name.text = userDTO.first_name + " " + userDTO.last_name
        Glide.with(holder.profile_image.context).load(userDTO.avatar).into(holder.profile_image)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var profile_image: CircleImageView
        var user_name: TextView

        init {
            profile_image = itemView.findViewById(R.id.profile_image)
            user_name = itemView.findViewById(R.id.user_name)
        }
    }



}