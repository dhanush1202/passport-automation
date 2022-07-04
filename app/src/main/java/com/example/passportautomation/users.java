package com.example.passportautomation;
public class users {
    private static String name;
    private static String email;
    private static String pan;


    public users() {
    }

    public users(String name, String email, String pan) {
        this.name = name;
        this.email = email;
        this.pan = pan;
    }

    public static String getName() {
        return name;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPan() {
        return pan;
    }
}
