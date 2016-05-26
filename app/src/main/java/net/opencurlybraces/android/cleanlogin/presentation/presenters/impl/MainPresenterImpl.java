package net.opencurlybraces.android.cleanlogin.presentation.presenters.impl;


import net.opencurlybraces.android.cleanlogin.domain.executor.Executor;
import net.opencurlybraces.android.cleanlogin.domain.executor.MainThread;
import net.opencurlybraces.android.cleanlogin.domain.interactors.LoginInteractor;
import net.opencurlybraces.android.cleanlogin.domain.interactors.impl.LoginInteractorImpl;
import net.opencurlybraces.android.cleanlogin.domain.model.User;
import net.opencurlybraces.android.cleanlogin.domain.repository.UserRepository;
import net.opencurlybraces.android.cleanlogin.presentation.presenters.MainPresenter;
import net.opencurlybraces.android.cleanlogin.presentation.presenters.base.AbstractPresenter;
import net.opencurlybraces.android.cleanlogin.storage.UserFactory;
import net.opencurlybraces.android.cleanlogin.storage.UserRepositoryImpl;

/**
 * Created by dmilicic on 12/13/15.
 */
public class MainPresenterImpl extends AbstractPresenter implements MainPresenter,
        LoginInteractor.Callback {

    private MainPresenter.View mView;
    private Executor mExectutor;
    private MainThread mMainThread;
    private UserRepository mUserRepository;

    public MainPresenterImpl(Executor executor,
                             MainThread mainThread,
                             View view) {
        super(executor, mainThread);
        mView = view;
        mExectutor = executor;
        mMainThread = mainThread;
        mUserRepository = new UserRepositoryImpl();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {
        mView.onUserLoginError(message);
    }

    @Override
    public void onClickLogin(String username, String password) {
        User user = UserFactory.createUser(username, password);
        logUserIn(user);
    }

    @Override
    public void onLoginSuccess(User user) {
        mView.onUserLogged(user);
    }

    @Override
    public void onLoginError(String error) {
        onError(error);
    }

    @Override
    public void logUserIn(User user) {
        LoginInteractor loginInteractor = new LoginInteractorImpl(
                mExectutor,
                mMainThread,
                this,
                mUserRepository,
                user);
        loginInteractor.execute();
    }
}
