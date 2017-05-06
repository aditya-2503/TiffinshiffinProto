package com.example.hp.slideactivity;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by HP on 11/25/2016.
 */

public class Menupull extends IntentService {
    public Menupull() {
        super("nameIntent");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle bst=intent.getExtras();
        int iy=bst.getInt("Mon");
        Dbhandl bds=new Dbhandl(getApplicationContext());



Schemadb sdf=bds.getContact(iy);
        String log = "Id: "+sdf.getId()+" ,Name: " + sdf.getBreakfast() + " ,Phone: " + sdf.getLunch();
        // Writing Contacts to log
        Log.d("Name: ", log);
        Intent intr=new Intent(getApplicationContext(),MenuDisp.class);
        intr.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_MULTIPLE_TASK);

        intr.putExtra("Brkf",sdf.getBreakfast());
        intr.putExtra("Lun",sdf.getLunch());
        intr.putExtra("Dinn",sdf.getDinner());
        startActivity(intr);
    }
}
