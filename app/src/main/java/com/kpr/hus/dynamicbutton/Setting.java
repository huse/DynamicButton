package com.kpr.hus.dynamicbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

 class Setting extends AppCompatActivity {
static TextView tv1;
    EditText et1;
    Button btSet;
    static float sensor=5f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        tv1= (TextView)findViewById(R.id.textView);
        et1= (EditText)findViewById(R.id.editText);
        et1.setText(Float.toString(sensor));
        btSet=(Button)findViewById(R.id.button);
        btSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ss= et1.getText().toString();
                //tv1.setText(ss);
                //ss=ss+"F";

               //Double dd= Double.parseDouble(tv1.getText().toString());
               sensor=Float.parseFloat(ss);
            }
        });
    }

public static float sensitivity(){



    return sensor;
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
