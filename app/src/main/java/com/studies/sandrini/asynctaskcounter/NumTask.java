package com.studies.sandrini.asynctaskcounter;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Sandrini on 07/11/2017.
 */

public class NumTask extends AsyncTask<Integer, Integer, Void> {

    private TextView txt;
    private Button btn;

    public NumTask(TextView txt, Button btn) {
        this.txt = txt;
        this.btn = btn;
    }

    @Override
    protected Void doInBackground(Integer... params) {
        int n = params[0];
        int i = 0;
        while (i < n){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            publishProgress(i);
            i++;
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        txt.setText(String.valueOf(values[0]));
    }
}
