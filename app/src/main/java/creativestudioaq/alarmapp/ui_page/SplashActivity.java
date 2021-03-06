package creativestudioaq.alarmapp.ui_page;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import creativestudioaq.alarmapp.R;

/**
 * Created by honggyu on 2016-01-31.
 */
public class SplashActivity extends Activity {

    SharedPreferences setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setting = getSharedPreferences("setting",0);
        final Boolean tutorial = setting.getBoolean("tutorial",true);

        setContentView(R.layout.activity_splash);
        ImageView dot = (ImageView)findViewById(R.id.splash_dot);
        RelativeLayout splashlayout = (RelativeLayout)findViewById(R.id.splashlayout);

        AlphaAnimation animation1 = new AlphaAnimation(0f, 1.0f);
        animation1.setDuration(3000);
        dot.startAnimation(animation1);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();

                if(tutorial==false){
                    intent.setClass(SplashActivity.this, MainActivity.class);
                }else{
                    intent.setClass(SplashActivity.this, TutorialActivity.class);
                }


                startActivity(intent);
                finish();

                // transition from splash to main menu
                overridePendingTransition(R.anim.fadein,
                        R.anim.fadeout);
                finish();
            }
        }, 3000);
    }
}
