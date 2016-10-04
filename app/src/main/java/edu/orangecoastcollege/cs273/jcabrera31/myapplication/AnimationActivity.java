package edu.orangecoastcollege.cs273.jcabrera31.myapplication;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    private ImageView lightsImageView;

    //used for frame animation
    private AnimationDrawable frameAnim;
    private Animation rotateAnim;
    private Animation shakeAnim;
    private Animation customAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);


    }
    public void toggleFrameAnim(View view)
    {
        //1. programmatically set the background of the image view to @drawble/lights1
        lightsImageView.setBackgroundResource(R.drawable.frame_anim);

        //2. Associate the framAnim with the animation in XML
        frameAnim = (AnimationDrawable) lightsImageView.getBackground();

        if(frameAnim.isRunning())
            frameAnim.stop();
        else //3. start the frame animation
            frameAnim.start();
    }

    public void toggleRotateAnim(View view){

        //load animation
        rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);

        //start animation
        lightsImageView.startAnimation(rotateAnim);
    }
    public void toggleShakeAnim(View view){

        if(shakeAnim != null && shakeAnim.hasStarted()){
            lightsImageView.clearAnimation();
            shakeAnim = null;
        }
        else
        {
            //load animation
            shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim) ;
            lightsImageView.startAnimation(shakeAnim);
        }
    }

    public void toggleCustomAnim(View view){

        if(customAnim != null && customAnim.hasStarted()){
            lightsImageView.clearAnimation();
            customAnim = null;
        }
        else
        {
            //load animation
            customAnim = AnimationUtils.loadAnimation(this, R.anim.custom_anim) ;
            lightsImageView.startAnimation(customAnim);
        }

    }
}
