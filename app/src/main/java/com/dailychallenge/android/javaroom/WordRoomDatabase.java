package com.dailychallenge.android.javaroom;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


//Annotate the class to be a Room database, declare the entities that belong in the database
// and set the version number. Listing the entities will create tables in the database.

@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {

    //Define the DAOs that work with the database. Provide an abstract "getter" method for each @Dao.
    public abstract WordDao wordDao();

    //Make the WordRoomDatabase a singleton to prevent having
    // multiple instances of the database opened at the same time.

    private static volatile WordRoomDatabase INSTANCE;

    static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here. This code uses Room's database builder to create
                    // a RoomDatabase object in the application context from the WordRoomDatabase class and names it "word_database".
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }




}
