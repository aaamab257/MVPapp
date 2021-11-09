package testproject.aaamab.mvpapp.data.login;

import com.google.gson.annotations.SerializedName;

public class DataObject {
    @SerializedName("name")
    String name ;

    @SerializedName("phone")
    String phone ;

    @SerializedName("gender")
    String gender ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
