package testproject.aaamab.mvpapp.ui.login;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import testproject.aaamab.mvpapp.data.login.LoginData;
import testproject.aaamab.mvpapp.data.login.LoginRequest;
import testproject.aaamab.mvpapp.network.ApiClient;
import testproject.aaamab.mvpapp.network.MainApiInterface;

import static android.service.controls.ControlsProviderService.TAG;

public class LoginPresenter {

    LoginInterface login ;
    MainApiInterface apiInterface ;

    public LoginPresenter(LoginInterface login) {
        this.login = login;
    }


    public void onBtnClick(){
        login.onMessage();
    }

    public void onLogin(String email , String pass){
        LoginRequest loginRequest = new LoginRequest(email , pass);

        apiInterface = ApiClient.getClient().create(MainApiInterface.class);
        Call<LoginData> call = apiInterface.login(loginRequest);
        call.enqueue(new Callback<LoginData>() {
            @Override
            public void onResponse(Call<LoginData> call, Response<LoginData> response) {
                login.onSuccess(response.body());
                Log.e(TAG, "onResponse: "+response.body().getCode() );
            }

            @Override
            public void onFailure(Call<LoginData> call, Throwable t) {
                login.onFail(t.getMessage());
            }
        });

    }

}
