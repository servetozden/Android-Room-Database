package com.example.androidroomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidroomdatabase.databinding.ActivityGetDataBinding;
import com.example.androidroomdatabase.databinding.ActivityUpdateItemBinding;

public class UpdateData extends AppCompatActivity {

    public ActivityUpdateItemBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_update_item);


        binding.name.setText(getIntent().getExtras().getString("name"));
        binding.lastName.setText(getIntent().getExtras().getString("lastName"));
        binding.birthDate.setText(getIntent().getExtras().getString("birthDate"));
        binding.country.setText(getIntent().getExtras().getString("cpuntry"));

        final String id = getIntent().getExtras().getString("id");

        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTxt = binding.name.getText().toString().trim();
                String lastNameTxt = binding.lastName.getText().toString().trim();
                String birthDate = binding.birthDate.getText().toString().trim();
                String country = binding.country.getText().toString().trim();

                if (nameTxt.equals("") || lastNameTxt.equals("") || birthDate.equals("") || country.equals("")) {
                    Toast.makeText(UpdateData.this, "All Field is required ....", Toast.LENGTH_SHORT).show();
                } else {
                    DatabaseClass.getDatabaseClass(getApplicationContext()).getDao().updateData(nameTxt, lastNameTxt, birthDate,country, Integer.parseInt(id));
                    finish();

                }
            }
        });








    }
}