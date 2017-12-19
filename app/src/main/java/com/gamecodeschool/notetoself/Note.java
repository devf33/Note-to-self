package com.gamecodeschool.notetoself;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Stanley on 12/12/2017.
 */

public class Note {

    private String mTitle;
    private String mDescription;
    private Boolean mIdea;
    private Boolean mTodo;
    private Boolean mImportant;
    private String JSON_TITLE = "title";
    private String JSON_DESCRIPTION = "description";
    private String JSON_IDEA = "idea";
    private String JSON_TODO = "todo";
    private String JSON_IMPORTANT = "important";

    // Constructor
    // Only used when new is called with a JSONObject
    public Note(JSONObject jo) throws JSONException {

        mTitle = jo.getString(JSON_TITLE);
        mDescription = jo.getString(JSON_DESCRIPTION);
        mIdea = jo.getBoolean(JSON_IDEA);
        mTodo = jo.getBoolean(JSON_TODO);
        mImportant = jo.getBoolean(JSON_IMPORTANT);
    }
    // Now we must provide an empty default constructor
    // for when we create a Note as we provide
    // specialized constructor that must be used.
    public Note (){

    }
    // This is where the Note object's members are packed
    // as a single JSONObject ready for when the actual
    // serialization takes place

    public JSONObject convertToJSON() throws JSONException{

        JSONObject jo = new JSONObject();

        jo.put(JSON_TITLE, mTitle);
        jo.put(JSON_DESCRIPTION, mDescription);
        jo.put(JSON_IDEA, mIdea);
        jo.put(JSON_TODO, mTodo);
        jo.put(JSON_IMPORTANT, mImportant);

        return jo;
    }


    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public Boolean isIdea() {
        return mIdea;
    }

    public void setIdea(Boolean mIdea) {
        this.mIdea = mIdea;
    }

    public Boolean isTodo() {
        return mTodo;
    }

    public void setTodo(Boolean mTodo) {
        this.mTodo = mTodo;
    }

    public Boolean isImportant() {
        return mImportant;
    }

    public void setImportant(Boolean mImportant) {
        this.mImportant = mImportant;
    }
}
