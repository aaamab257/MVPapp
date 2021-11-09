package testproject.aaamab.mvpapp.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import testproject.aaamab.mvpapp.R;
import testproject.aaamab.mvpapp.data.login.LoginData;
import testproject.aaamab.mvpapp.databinding.ActivityLoginScreenBinding;

public class LoginScreen extends AppCompatActivity implements LoginInterface {

    Button loginBtn ;
    LoginPresenter presenter ;
    ActivityLoginScreenBinding binding;
    MyHandler handler ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this ,R.layout.activity_login_screen);
        handler = new MyHandler(this);
        presenter = new LoginPresenter(this);
        binding.setHandler(handler);
    }


    @Override
    public void onMessage() {
        Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(LoginData loginData) {
        binding.txtName.setText(loginData.getData().getName());
        binding.txtGender.setText(loginData.getData().getGender());
        binding.txtPhone.setText(loginData.getData().getPhone());
    }

    @Override
    public void onFail(String error) {

    }

    public class MyHandler{
        Context context ;

        public MyHandler(Context context) {
            this.context = context;
        }

        public void login(View v){
            String email = binding.edEmail.getText().toString();
            String password = binding.edPassword.getText().toString();
            presenter.onLogin(email , password);
        }
    }
}