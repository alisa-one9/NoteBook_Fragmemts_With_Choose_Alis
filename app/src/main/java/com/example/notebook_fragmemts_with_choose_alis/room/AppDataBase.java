package com.example.notebook_fragmemts_with_choose_alis.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.notebook_fragmemts_with_choose_alis.models.TextModel;

@Database(entities = {TextModel.class},version = 1)

public abstract class AppDataBase extends RoomDatabase {
    public abstract NoteDao noteDao();

}
