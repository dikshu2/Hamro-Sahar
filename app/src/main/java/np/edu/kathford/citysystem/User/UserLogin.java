package np.edu.kathford.citysystem.User;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import np.edu.kathford.citysystem.R;

public class UserLogin extends AppCompatActivity {
    private EditText login_emailId, login_password;
    private CheckBox showPassword;
    private Button login_btn;
    private TextView create_account, signupHereTextView, resetPassword;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //receiving data from signup
        Intent i=getIntent();
        int id=i.getIntExtra("id",001);
        String name1=i.getStringExtra("full_name");
        String address1=i.getStringExtra("location");
        String email1=i.getStringExtra("Email_Id");
        String password1=i.getStringExtra("password");
        String number1=i.getStringExtra("mobile_number");

        login_emailId= findViewById(R.id.userEmailId);
        login_password=findViewById(R.id.password);
        login_btn=findViewById(R.id.loginBtn);
        showPassword=findViewById(R.id.show_hide_password);
        create_account=findViewById(R.id.createAccount);
        signupHereTextView=findViewById(R.id.createAccount);
        resetPassword=findViewById(R.id.forgot_password);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = login_emailId.getText().toString().trim();
                String password = login_password.getText().toString().trim();
                String submit_button = login_btn.getText().toString().trim();

                if(email1==email){
                    if(password1==password){
                        Toast.makeText(UserLogin.this, "Successful login", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(UserLogin.this, "Password Incorrect", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(UserLogin.this, "Email Incorrect", Toast.LENGTH_LONG).show();
                }

                //passing data to ResetPassword
                Intent in= new Intent(UserLogin.this,ResetPassword.class);
                in.putExtra("id", 002);
                in.putExtra("email" ,email);

            }
        });
        signupHereTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(UserLogin.this,UserSignup.class);
                startActivity(intent);
            }
        });
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent (UserLogin.this,ResetPassword.class);
                startActivity(intent);
            }
        });
    }
}
