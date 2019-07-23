package com.dailychallenge.android.javaroom;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDAO {

    //Declare a method to insert one word
    @Insert
    void insert (Word word);

    //Declare a method to delete all the words
    //There is no convenience annotation for deleting multiple entities,
    // so annotate the method with the generic

    @Query("DELETE FROM word_table")
    void deleteAll();

    //Create a method to get all the words:

    @Query("SELECT * from word_table ORDER BY word ASC")
    List<Word> getAllWords();


    /*Tip: When inserting data, you can provide a conflict strategy.
    In this codelab, you do not need a conflict strategy, because the word is your primary key,
     and the default SQL behavior is ABORT, so that you cannot insert two items
     with the same primary key into the database.
    If the table has more than one column, you can use
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    to replace a row. */

}
