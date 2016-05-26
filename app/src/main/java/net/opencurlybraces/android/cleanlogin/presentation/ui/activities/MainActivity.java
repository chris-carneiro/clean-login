package net.opencurlybraces.android.cleanlogin.presentation.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.kodelabs.boilerplate.R;

import net.opencurlybraces.android.cleanlogin.domain.executor.impl.ThreadExecutor;
import net.opencurlybraces.android.cleanlogin.domain.model.User;
import net.opencurlybraces.android.cleanlogin.presentation.presenters.MainPresenter;
import net.opencurlybraces.android.cleanlogin.presentation.presenters.impl.MainPresenterImpl;
import net.opencurlybraces.android.cleanlogin.threading.MainThreadImpl;


public class MainActivity extends AppCompatActivity implements MainPresenter.View, View.OnClickListener {


    private TextView mLoggedUser;
    private Button mLoginButton;
    private EditText mUsername;
    private EditText mPassword;
    private MainPresenterImpl mPresenter;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }


    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onUserLogged(User user) {
        mLoggedUser.setText("Welcome " + user.toString());
        mLoggedUser.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark));
        hideProgress();
    }

    @Override
    public void onUserLoginError(String error) {
        mLoggedUser.setText("Nope");
        mLoggedUser.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
        hideProgress();
    }

    @Override
    public void onClick(View view) {
        User user = new User(mUsername.getText().toString(), mPassword.getText().toString());
        mPresenter.logUserIn(user);
        showProgress();
        hideSoftKeyboard(view);
    }

    private void init() {
        mLoggedUser = (TextView) findViewById(R.id.logged_username);
        mLoginButton = (Button) findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(this);
        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        mPresenter = new MainPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    private void hideSoftKeyboard(final View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
