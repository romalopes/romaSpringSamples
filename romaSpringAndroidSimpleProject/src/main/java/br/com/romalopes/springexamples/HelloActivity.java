package br.com.romalopes.springexamples;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 23/11/13
 * Time: 23:01
 * To change this template use File | Settings | File Templates.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import org.joda.time.LocalTime;

public class HelloActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_layout);
    }

    @Override
    public void onStart() {
        super.onStart();
        LocalTime currentTime = new LocalTime();
        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText("The current local time is: " + currentTime);
    }

}
