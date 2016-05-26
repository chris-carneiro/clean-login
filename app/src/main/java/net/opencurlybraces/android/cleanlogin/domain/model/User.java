package net.opencurlybraces.android.cleanlogin.domain.model;

/**
 * A sample model. Replace this with your own.
 */
public class User {

    private final String mUsername;
    private final transient String mPassword;
    private boolean mIsLogged = false;


    public User(String username, String password) {
        this.mUsername = username;
        this.mPassword = password;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getPassword() {
        return mPassword;
    }

    public boolean isLogged() {
        return mIsLogged;
    }

    @Override
    public String toString() {
        return mUsername;
    }

    public void setLogged(boolean logged) {
        mIsLogged = logged;
    }


}
