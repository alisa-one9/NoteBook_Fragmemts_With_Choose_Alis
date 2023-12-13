package com.example.notebook_fragmemts_with_choose_alis.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notebook_fragmemts_with_choose_alis.models.TextModel;

import java.util.List;
@Dao
public interface NoteDao {
    @Query("SELECT*FROM ttt")
    List<TextModel> getAll();

    @Insert
    void insert(TextModel textModel);

    @Query("SELECT*FROM ttt")
    LiveData<List<TextModel>> getAllLive();

    @Delete
    void delete(TextModel textModel);

    @Update
    void update(TextModel textModel);


}
