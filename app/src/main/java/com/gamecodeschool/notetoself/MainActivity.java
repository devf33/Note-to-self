package com.gamecodeschool.notetoself;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NoteAdapter mNoteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNoteAdapter = new NoteAdapter();

        ListView noteList = (ListView) findViewById(R.id.listView);

        noteList.setAdapter(mNoteAdapter);

        // Handle clicks on ListView
        noteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int whichItem, long id) {

                /*
                Create a temporary Note
                Which is a Reference to the Note
                that has just been clicked
                 */

                Note tempNote = mNoteAdapter.getItem(whichItem);
                // Create a new dialog window
                DialogShowNote dialog = new DialogShowNote();
                // Send in a reference to the note to be shown
                dialog.sendNoteSelected(tempNote);

                // Show the dialog window with the note in it
                dialog.show(getFragmentManager(), "");

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
            DialogNewNote dialog = new DialogNewNote();
            dialog.show(getFragmentManager(), "");
            return true;
        }
            return true;
        }

    public void createNewNote(Note n) {

        mNoteAdapter.addNote(n);

    }

    public class NoteAdapter extends BaseAdapter {

        List<Note> noteList = new ArrayList<Note>();

        @Override
        public int getCount() {
            return noteList.size();
        }

        @Override
        public Note getItem(int whichItem) {
            return noteList.get(whichItem);
        }

        @Override
        public long getItemId(int whichItem) {
            return whichItem;
        }

        @Override
        public View getView(int whichItem, View view, ViewGroup viewGroup)
        {

            // Implement this method next
            // Has view been inflated already
            if(view == null){

                // If not, do so here
                // First create a LayoutInflater
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                // Now instantiate view using inflater.inflate
                // using the listitem layout
                view = inflater.inflate(R.layout.listitem, viewGroup,false);
                // The false parameter is necessary
                // because of the way that we want to use listitem

            }// End if

            // Grab a reference to all our TextView and ImageView widgets
            TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            TextView txtDescription = (TextView) view.findViewById(R.id.txtDescription);
            ImageView ivImportant = (ImageView) view.findViewById(R.id.imageViewImportant);
            ImageView ivTodo = (ImageView) view.findViewById(R.id.imageViewTodo);
            ImageView ivIdea = (ImageView) view.findViewById(R.id.imageViewIdea);

            // Hide an ImageView widget that are not relevant
            Note tempNote = noteList.get(whichItem);

            if (!tempNote.isImportant()){
                ivImportant.setVisibility(View.GONE);
            }

            if (!tempNote.isTodo()){
                ivTodo.setVisibility(View.GONE);
            }

            if (!tempNote.isIdea()){
                ivIdea.setVisibility(View.GONE);
            }

            // Add the text to the heading and description
            txtTitle.setText(tempNote.getTitle());
            txtDescription.setText(tempNote.getDescription());

            return view;

        }

        public void addNote(Note n){

            noteList.add(n);
            notifyDataSetChanged();
        }

    }
}


