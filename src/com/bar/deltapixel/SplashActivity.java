package com.bar.deltapixel;

import android.support.v7.app.ActionBarActivity;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends ActionBarActivity {
	ImageView logo, writtenlogo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        
        logo = (ImageView)findViewById(R.id.splashlogo);
        writtenlogo = (ImageView)findViewById(R.id.writtenlogo);
        
        loadAnimation(logo);
        
        Handler handler = new Handler(); 
        handler.postDelayed(new Runnable() { 
             public void run() { 
            	 loadAnimation(writtenlogo);
             } 
        }, 500);         
        
        /*int secondsDelayed = 3;
        new Handler().postDelayed(new Runnable() {
                public void run() {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        finish();
                }
        }, secondsDelayed * 1000);*/
	}

	public void loadAnimation(ImageView img)
	{
		AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.flipping);
		set.setTarget(img);
		set.start();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
