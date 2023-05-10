package np.edu.kathford.citysystem.User;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import np.edu.kathford.citysystem.R;


public class UserSignup extends AppCompatActivity {
    private EditText full_name, email_id, mobile_number, location, password, confirm_password;
    private CheckBox terms_and_conditions;
    private Button signup;
    private TextView login_here;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        full_name=findViewById(R.id.fullName);
        email_id=findViewById(R.id.userEmailId);
        mobile_number=findViewById(R.id.mobileNumber);
        location=findViewById(R.id.location);
        password=findViewById(R.id.password);
        confirm_password=findViewById(R.id.confirmPassword);
        terms_and_conditions=findViewById(R.id.terms_conditions);
        signup=findViewById(R.id.signUpBtn);
        login_here=findViewById(R.id.already_user);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, email, number, address, pw, confirm_pw;
                name = full_name.getText().toString();
                email = email_id.getText().toString();
                number = mobile_number.getText().toString();
                address = location.getText().toString();
                pw = password.getText().toString();
                confirm_pw = confirm_password.getText().toString();
                String pattern = "^[a-zA-Z ]+$";
                if (name.isEmpty()) {
                    full_name.setError("Full name is required");
                    full_name.requestFocus();
                    return;
                }

                if (!name.matches(pattern)) {
                    full_name.setError("Full name should contain only letters");
                    full_name.requestFocus();
                    return;
                }

                if (email.isEmpty()) {
                    email_id.setError("Email is required");
                    email_id.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    email_id.setError("Please enter a valid email address");
                    email_id.requestFocus();
                    return;
                }

                if (number.isEmpty()) {
                    mobile_number.setError("Phone number is required");
                    mobile_number.requestFocus();
                    return;
                }
                if (number.length() != 10) {
                    mobile_number.setError("Mobile number should have 10 digits");
                    mobile_number.requestFocus();
                    return;
                }

                if (address.isEmpty()) {
                    location.setError("Location is required");
                    location.requestFocus();
                    return;
                }

                if (pw.isEmpty()) {
                    password.setError("Password is required");
                    password.requestFocus();
                    return;
                }

                if (pw.length() <=8) {
                    password.setError("Password should be at least 8 characters long");
                    password.requestFocus();
                    return;
                }

                if (confirm_pw.isEmpty()) {
                    confirm_password.setError("Confirm password is required");
                    confirm_password.requestFocus();
                    return;
                }

                if (!confirm_pw.equals(pw)) {
                    confirm_password.setError("Passwords do not match");
                    confirm_password.requestFocus();
                    return;
                }
                //passing data to User-login
                Intent i= new Intent(UserSignup.this, UserLogin.class);
                i.putExtra("id",001);
                i.putExtra("full_name", name);
                i.putExtra("Email_Id", email);
                i.putExtra("mobile_number", number);
                i.putExtra("location", address);
                i.putExtra("password", pw);
                startActivity(i);

            }
        });
    }
}
