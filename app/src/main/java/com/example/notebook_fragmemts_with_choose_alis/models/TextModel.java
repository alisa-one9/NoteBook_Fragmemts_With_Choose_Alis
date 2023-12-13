package com.example.notebook_fragmemts_with_choose_alis.models;

import androidx.recyclerview.widget.RecyclerView;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = "ttt")
public class TextModel  {
    @PrimaryKey(autoGenerate = true)
    private long id;

@ColumnInfo(name ="textC")
    public String textC;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTextC() {
        return textC;
    }

    public void setTextC(String textC) {
        this.textC = textC;
    }
}
