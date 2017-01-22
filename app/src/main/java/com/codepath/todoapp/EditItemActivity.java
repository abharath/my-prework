package com.codepath.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    EditText etEditText;
    int position = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        etEditText = (EditText) findViewById(R.id.etEditText1);
        etEditText.setText(getIntent().getCharSequenceExtra("text"));
        position = getIntent().getIntExtra("pos", -1);
        etEditText.setSelection(etEditText.getText().length());
        etEditText.requestFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public void onSubmit(View v) {
        // closes the activity and returns to first screen
        this.finish();
    }

    public void OnSaveItem (View v) {
        EditText editText = (EditText) findViewById(R.id.etEditText1);
        String newToDo = editText.getText().toString();
        Intent data = new Intent();
        data.putExtra("saveItem", newToDo);
        data.putExtra("pos", position);
        InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        setResult(RESULT_OK, data);
        finish();
    }
}