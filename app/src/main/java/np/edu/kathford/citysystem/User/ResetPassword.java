package np.edu.kathford.citysystem.User;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import np.edu.kathford.citysystem.R;

public class ResetPassword extends AppCompatActivity {
    private EditText emailResetPw, passwordResetPw, newPassword, confirmNewPassword;
    private TextView submitResetPw, backResetPw;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        //receiving data from UserLogin
        Intent in = getIntent();
        int id=in.getIntExtra("id",002);
        String receivedEmail=in.getStringExtra("email");
        String receivedPassword=in.getStringExtra("password");

        emailResetPw = findViewById(R.id.registered_emailid);
        newPassword=findViewById(R.id.newPassword);
        confirmNewPassword=findViewById(R.id.confirm_Password);
        submitResetPw=findViewById(R.id.reset_button);
        backResetPw=findViewById(R.id.backToLogin);

        submitResetPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getting data
                String emailResetPassword=emailResetPw.getText().toString().trim();
                String newPw= newPassword.getText().toString().trim();
                String confirmNewPw=confirmNewPassword.getText().toString().trim();


                //data validation
                if(receivedEmail!=emailResetPassword){
                    emailResetPw.setError("Please enter your registered email");
                    emailResetPw.requestFocus();
                }
                if (newPw.length() <=8) {
                    newPassword.setError("Password should be at least 8 characters long");
                    newPassword.requestFocus();

                }

                if (newPw.isEmpty()) {
                    newPassword.setError("Confirm password is required");
                    newPassword.requestFocus();

                }

                if (!confirmNewPw.equals(newPw)) {
                    confirmNewPassword.setError("Passwords do not match");
                    confirmNewPassword.requestFocus();

                }

            }
        });

        backResetPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResetPassword.this, UserLogin.class);
                startActivity(intent);

            }
        });

    }
    }

