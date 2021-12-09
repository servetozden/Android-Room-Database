package com.example.androidroomdatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidroomdatabase.Adapter.UserAdapter;
import com.example.androidroomdatabase.EntityClass.EntityUserModel;
import com.example.androidroomdatabase.databinding.ActivityGetDataBinding;

import java.util.ArrayList;
import java.util.List;

public class GetData extends AppCompatActivity {

    public ActivityGetDataBinding binding;

    RecyclerView recyclerView;

    private List<EntityUserModel> entityUserModelList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_get_data);

        recyclerView = findViewById(R.id.recyclerview);



    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    private void getData(){
        entityUserModelList = new ArrayList<>();
        entityUserModelList = DatabaseClass.getDatabaseClass(getApplicationContext()).getDao().getAll();
        recyclerView.setAdapter(new UserAdapter(getApplicationContext(), entityUserModelList, new UserAdapter.DeleteItemClicklistner() {
            @Override
            public void onItemDelete(int position, int id) {
                DatabaseClass.getDatabaseClass(getApplicationContext()).getDao().deleteData(id);
                getData();
            }
        }));
    }
}