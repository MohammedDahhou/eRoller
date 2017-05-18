package fr.utbm.tokylabs.eroller;

import android.app.Activity;
import android.os.Bundle;

import com.github.lzyzsd.circleprogress.CircleProgress;

public class BatteryActivity extends Activity {
    private CircleProgress circleProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_battery);
        circleProgress =(CircleProgress) findViewById(R.id.circle_progress_autonomie);
        circleProgress.setProgress(55);
    }
}
