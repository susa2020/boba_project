package com.example.susa_boba_project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class addThingPage extends AppCompatActivity {
    private Button memo_added_button;
    private EditText type_memo;
    public Integer cnt=0;
    SharedPreferences thingsToDo = getSharedPreferences("toDoList", MODE_PRIVATE);
    protected void onCreate( Bundle saveInstanceState ){
        super.onCreate( saveInstanceState );
        setContentView( R.layout.pop_up_memo_added );
        type_memo = ( EditText )findViewById( R.id.type_memo );
       // memo_added_button = ( Button )findViewById( R.id.memo_added_button );
       // memo_added_button.setOnClickListener( addThingToTheList );
    }
  /*  private Button.OnClickListener addThingToTheList =
            new Button.OnClickListener(){
            @Override
                public void Onclick( View v ){
                    public String thingThatAddedNow = type_memo.getText().toString();
                    if( thingThatAddedNow.length() == 0 ){
                        Toast nothingHasInputed = Toast.makeText( addThingPage.this , "輸入為空!" , Toast.LENGTH_SHORT );
                        nothingHasInputed.show();
                    }
                    else{
                        thingsToDo.edit()
                                .putString( cnt , thingThatAddedNow )
                                .commit();
                        Toast thingHasBeenAdded = Toast.makeText( addThingPage.this , "您輸入的事項已被新增!" , Toast.LENGTH_SHORT );
                        thingHasBeenAdded.show();
                        Intent intent = new Intent();
                        intent.setClass( addThingPage.this , MainActivity.class );
                        startActivity( intent );
                    }
                }
            };*/
}