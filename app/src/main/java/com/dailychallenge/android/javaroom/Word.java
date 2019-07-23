package com.dailychallenge.android.javaroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {


    //tip : if you want to autogenerate: @PrimaryKey(autoGenerate = true)
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;


    public Word(@NonNull String word) {
        this.mWord = word;
    }

    //Every field that's stored in the database needs to be either public
    // or have a "getter" method. This sample provides a getWord() method.
    public String getWord(){
        return this.mWord;
    }
}
