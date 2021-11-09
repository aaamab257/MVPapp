package testproject.aaamab.mvpapp.network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import testproject.aaamab.mvpapp.data.login.LoginData;
import testproject.aaamab.mvpapp.data.login.LoginRequest;

public interface MainApiInterface {

    @POST("login")
    Call<LoginData> login(@Body LoginRequest loginRequest);

}
