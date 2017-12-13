package com.gamecodeschool.notetoself;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Temporary code
    Note mTempNote = new Note();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Temporary code
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create a new DialogShowNote called dialog
                DialogShowNote dialog = new DialogShowNote();

                // Send the note via the sendNoteSelected method
                dialog.sendNoteSelected(mTempNote);

                // Create a dialog
                dialog.show(getFragmentManager(), "123");
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add){
            DialogNewNote dialog =new DialogNewNote();
            dialog.show(getFragmentManager(), "");
            return true;
        }
            return true;
        }

    public void createNewNote(Note n) {
        // Temporary code
        mTempNote = n;
    }
}


