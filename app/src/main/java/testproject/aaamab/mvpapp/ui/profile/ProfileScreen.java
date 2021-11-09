package testproject.aaamab.mvpapp.ui.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import testproject.aaamab.mvpapp.R;
import testproject.aaamab.mvpapp.databinding.ActivityProfileScreenBinding;

public class ProfileScreen extends AppCompatActivity {

    ActivityProfileScreenBinding binding ;
    MyHandler handler ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this ,R.layout.activity_profile_screen);
        handler = new MyHandler(this);
        binding.setBtnsClick(handler);


    }


    public class MyHandler{
        Context context ;

        public MyHandler(Context context) {
            this.context = context;
        }

        public void clickMe(View view){
            Toast.makeText(context, "You Clicked Me", Toast.LENGTH_LONG).show();
        }


    }

}
