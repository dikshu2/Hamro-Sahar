package np.edu.kathford.citysystem.Common;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import np.edu.kathford.citysystem.R;
import np.edu.kathford.citysystem.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIMER=5000;
    ImageView backgroundImageView;
    TextView nameTextView;
    //animation
    Animation bottomAnim, sideAnim;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);
//hooks
        backgroundImageView=findViewById(R.id.backgroundImageView);
        nameTextView=findViewById(R.id.nameTextView);
        //animation
        sideAnim= AnimationUtils.loadAnimation(this,R.anim.side_anim);
        sideAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //set animation on element
        backgroundImageView.setAnimation(sideAnim);
        nameTextView.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen.this, UserDashboard.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_TIMER);


    }
}
