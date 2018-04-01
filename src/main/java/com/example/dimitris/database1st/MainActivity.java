package com.example.dimitris.database1st;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;



public class MainActivity extends AppCompatActivity {
    EditText bookTitle, publisher;
    //RatingBar ratingBar;

    int rating;
    private static final String TAG = "MyHelper";

    MyHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookTitle = (EditText) findViewById(R.id.book);
        publisher = (EditText) findViewById(R.id.bookPublisher);

        //ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        //ratingBar.setRating(0);
        rating = 5;
        setContentView(R.layout.activity_main);
        myDb = new MyHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void addEntry(View v){
        bookTitle = (EditText) findViewById(R.id.book);
        publisher = (EditText) findViewById(R.id.bookPublisher);



        myDb = new MyHelper(this);
        String title = bookTitle.getText().toString();
        String bookPublisher = publisher.getText().toString();
        //int rating = ratingBar.getNumStars();
        boolean success = myDb.addRecord(title, bookPublisher, rating);

        if(success){
            Toast.makeText(this, "ADDED", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "ALREADY INSERTED", Toast.LENGTH_SHORT).show();
        }
        bookTitle.setText("");
        publisher.setText("");
        //ratingBar.setRating(0);

    }

    public void deleteEntry(View v){
        bookTitle = (EditText) findViewById(R.id.book);
        publisher = (EditText) findViewById(R.id.bookPublisher);



        myDb = new MyHelper(this);
        String title = bookTitle.getText().toString();
        String bookPublisher = publisher.getText().toString();
        boolean result = myDb.deleteRecord(title,bookPublisher);

        if(result){//If record deleted
            bookTitle.setText("");
            publisher.setText("");
            Toast.makeText(this, "Book Deleted", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "No match found", Toast.LENGTH_SHORT).show();
        }


    }






}
