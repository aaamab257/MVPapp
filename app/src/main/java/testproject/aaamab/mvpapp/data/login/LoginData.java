package testproject.aaamab.mvpapp.data.login;

import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("code")
    int code ;

    @SerializedName("data")
    DataObject data ;

    public DataObject getData() {
        return data;
    }

    public void setData(DataObject data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
