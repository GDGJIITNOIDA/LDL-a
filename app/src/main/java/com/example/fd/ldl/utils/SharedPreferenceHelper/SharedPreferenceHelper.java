package com.example.fd.ldl.utils.SharedPreferenceHelper;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.fd.ldl.Model.User;

public class SharedPreferenceHelper {

    private static final String SHARED_PREF_NAME = "LDL";

    public static void saveAsCurrentUser(Context context, User user) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(User.USER_ID, user.getUserId());
        editor.putInt(User.ROLE, user.getRole());
        editor.putString(User.EMAIL, user.getEmail());
        editor.putString(User.FIRSTNAME, user.getFirstName());
        editor.putString(User.LASTNAME, user.getLastName());
        editor.putString(User.TOKEN, user.getToken());
        editor.putString(User.PASSWORD, user.getPassword());
        editor.putString(User.USERNAME, user.getUsername());
        editor.apply();
    }

    public static User getCurrentUser(Context context) {
        SharedPreferences sharePreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        User user = new User();
        user.setUserId(sharePreferences.getInt(User.USER_ID, 0));
        user.setRole(sharePreferences.getInt(User.ROLE, 0));
        user.setEmail(sharePreferences.getString(User.EMAIL, ""));
        user.setUsername(sharePreferences.getString(User.USERNAME, ""));
        user.setFirstName(sharePreferences.getString(User.FIRSTNAME, ""));
        user.setLastName(sharePreferences.getString(User.LASTNAME, ""));
        user.setToken(sharePreferences.getString(User.TOKEN, ""));
        user.setPassword(sharePreferences.getString(User.PASSWORD,""));

        return user;
    }

}
