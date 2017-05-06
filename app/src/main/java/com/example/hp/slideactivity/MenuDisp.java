package com.example.hp.slideactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by HP on 11/25/2016.
 */

public class MenuDisp extends AppCompatActivity {
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    public void onCreate(Bundle onst){
        super.onCreate(onst);
        setContentView(R.layout.menu1_disp);
        Intent iu=getIntent();
        txt1=(TextView)findViewById(R.id.tbletxt1);
        txt2=(TextView)findViewById(R.id.tbletxt2);
        txt3=(TextView)findViewById(R.id.tbletxt3);
        Bundle b=iu.getExtras();

        txt1.setText((String)b.get("Brkf"));
        txt2.setText((String)b.get("Lun"));
        txt3.setText((String)b.get("Dinn"));
    }

}
