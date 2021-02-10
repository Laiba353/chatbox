package com.example.chatsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chatsapp.databinding.RowConversationBinding;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UnderViewHolder> {
    Context context;
    ArrayList <User> users;
    public UsersAdapter(Context context, ArrayList <User> users)
    {
this.context=context;
this.users=users;

    }
    @NonNull
    @Override
    public UnderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_conversation,parent,false);
        return new UnderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UnderViewHolder holder, int position) {
User user=users.get(position);
holder.binding.username.setText(user.getName());
 Glide.with(context).load(user.getProfileImage())
         .placeholder(R.drawable.profile)
         .into(holder.binding.imageView);
 holder.itemView.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         Intent intent=new Intent(context,ChatActivity.class);
         intent.putExtra("name",user.getName());
         intent.putExtra("uid",user.getUid());
         context.startActivity(intent);
     }
 });


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UnderViewHolder extends RecyclerView.ViewHolder
    {

        RowConversationBinding binding;

        public UnderViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=RowConversationBinding.bind(itemView);

        }
    }
}
