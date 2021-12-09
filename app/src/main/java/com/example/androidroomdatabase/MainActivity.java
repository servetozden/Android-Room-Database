package com.example.androidroomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidroomdatabase.EntityClass.EntityUserModel;
import com.example.androidroomdatabase.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

       binding.btnSave.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               saveData();
           }
       });


       binding.btnGetData.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(getApplicationContext(), GetData.class));

           }
       });


    }

    private void saveData(){
        String nameText = binding.nameTxt.getText().toString().trim();
        String lastNameText = binding.lastNameTxt.getText().toString().trim();
        String birthDateText = binding.birthDateTxt.getText().toString().trim();
        String countryText = binding.countryTxt.getText().toString().trim();


        EntityUserModel entityUserModel = new EntityUserModel();
        entityUserModel.setFirstName(nameText);
        entityUserModel.setLastName(lastNameText);
        entityUserModel.setBirthDate(birthDateText);
        entityUserModel.setCountry(countryText);

        DatabaseClass.getDatabaseClass(getApplicationContext()).getDao().insertAllData(entityUserModel);



        binding.nameTxt.setText("");
        binding.lastNameTxt.setText("");
        binding.birthDateTxt.setText("");
        binding.countryTxt.setText("");
        Toast.makeText(this, "Data Successfully Saved", Toast.LENGTH_SHORT).show();


    }


}