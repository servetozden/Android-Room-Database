package com.example.androidroomdatabase.Dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.androidroomdatabase.EntityClass.EntityUserModel;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertAllData(EntityUserModel model);

    @Query("SELECT * FROM user")
    List<EntityUserModel> getAll();

    @Query("delete from user where `id`= :id")
    void deleteData(int id);

    @Query("update user SET first_name= :firstName, last_name= :lastName, birth_date= :birthDate, country= :Country where `id`= :id")
    void updateData(String firstName, String lastName, String birthDate, String Country, int id);




}
