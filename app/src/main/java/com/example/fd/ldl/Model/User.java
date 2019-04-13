package com.example.fd.ldl.Model;

import android.content.Context;

import com.example.fd.ldl.utils.SharedPreferenceHelper.SharedPreferenceHelper;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

                    public static final String USER_ID = "User Id";
                    public static final String TOKEN = "token";
                    public static final String FIRSTNAME = "first_name";
                    public static final String EMAIL = "email";
                    public static final String USERNAME = "user_name";
                    public static final String ROLE = "role";
                    public static final String LASTNAME = "last_name";
                    public static final String PASSWORD = "password";


        @SerializedName("token")
        @Expose
        private String token;
        @SerializedName("first_name")
        @Expose
        private String firstName;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("role")
        @Expose
        private Integer role;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("password")
        @Expose
        private String password;



    public User() {
    }

    public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getRole() {
            return role;
        }

        public void setRole(Integer role) {
            this.role = role;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }


public static User getCurrentUser(Context context){
         return SharedPreferenceHelper.getCurrentUser(context);
}

public static void setAsCurrentUser(Context context, User currentUser) {
        SharedPreferenceHelper.saveAsCurrentUser(context,currentUser);
    }
}
