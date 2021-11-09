package testproject.aaamab.mvpapp.ui.login;

import testproject.aaamab.mvpapp.data.login.LoginData;

public interface LoginInterface {

    void onMessage();

    void onSuccess(LoginData loginData);

    void onFail(String error);

}
