package np.edu.kathford.citysystem.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import np.edu.kathford.citysystem.R;

public class UserDashboard extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        LinearLayout loginButton= findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(UserDashboard.this, UserLogin.class);
                startActivity(intent);
            }
        });
        LinearLayout category= findViewById(R.id.category);
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserDashboard.this,Category.class);
                startActivity(intent);
            }
        });

    }

}
