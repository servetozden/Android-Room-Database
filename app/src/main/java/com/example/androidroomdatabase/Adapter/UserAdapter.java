package com.example.androidroomdatabase.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidroomdatabase.EntityClass.EntityUserModel;
import com.example.androidroomdatabase.R;
import com.example.androidroomdatabase.UpdateData;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewModel> {

    Context context;
    List<EntityUserModel> entityUserModelList;
    DeleteItemClicklistner deleteItemClicklistner;

    public UserAdapter(Context context, List<EntityUserModel> entityUserModelList, DeleteItemClicklistner deleteItemClicklistner) {
        this.context = context;
        this.entityUserModelList = entityUserModelList;
        this.deleteItemClicklistner = deleteItemClicklistner;
    }


    @NonNull
    @Override
    public ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewModel(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewModel holder, int position) {

        holder.name.setText(entityUserModelList.get(position).getFirstName());
        holder.lastName.setText(entityUserModelList.get(position).getLastName());
        holder.birthDate.setText(entityUserModelList.get(position).getBirthDate());
        holder.country.setText(entityUserModelList.get(position).getCountry());

        holder.buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateData.class);
                intent.putExtra("id", String.valueOf(entityUserModelList.get(position).getId()));
                intent.putExtra("name", String.valueOf(entityUserModelList.get(position).getFirstName()));
                intent.putExtra("lastName",String.valueOf(entityUserModelList.get(position).getLastName()));
                intent.putExtra("birthDate", String.valueOf(entityUserModelList.get(position).getBirthDate()));
                intent.putExtra("country", String.valueOf(entityUserModelList.get(position).getCountry()));
                context.startActivity(intent);
            }

        });

        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteItemClicklistner.onItemDelete(position,entityUserModelList.get(position).getId());
            }
        });



    }

    @Override
    public int getItemCount() {
        return entityUserModelList.size();
    }

    class ViewModel extends RecyclerView.ViewHolder{

        TextView name, lastName, birthDate, country;
        Button buttonUpdate, buttonDelete;

        public ViewModel(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textName);
            lastName = itemView.findViewById(R.id.textLastName);
            birthDate = itemView.findViewById(R.id.textBirthDate);
            country  = itemView.findViewById(R.id.textCountry);
            buttonUpdate = itemView.findViewById(R.id.buttonUpdate);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);




        }
    }

    public interface DeleteItemClicklistner {
        void onItemDelete(int position, int id);
    }
}
