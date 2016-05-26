package net.opencurlybraces.android.cleanlogin.domain.interactors.impl;

import net.opencurlybraces.android.cleanlogin.domain.executor.Executor;
import net.opencurlybraces.android.cleanlogin.domain.executor.MainThread;
import net.opencurlybraces.android.cleanlogin.domain.interactors.LoginInteractor;
import net.opencurlybraces.android.cleanlogin.domain.interactors.base.AbstractInteractor;
import net.opencurlybraces.android.cleanlogin.domain.model.User;
import net.opencurlybraces.android.cleanlogin.domain.repository.UserRepository;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p>
 */
public class LoginInteractorImpl extends AbstractInteractor implements LoginInteractor {

    private Callback mCallback;
    private UserRepository mUserRepository;
    private final User mUser;

    public LoginInteractorImpl(Executor threadExecutor,
                               MainThread mainThread,
                               Callback callback, UserRepository userRepository, User user) {
        super(threadExecutor, mainThread);
        mCallback = callback;
        mUserRepository = userRepository;
        mUser = user;
    }

    private void postMessage(final User user) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onLoginSuccess(user);
            }
        });

    }

    private void notifyError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onLoginError("fefe");
            }
        });
    }

    private boolean credentialsOk(User user1, User user2) {
        return user1.getPassword().equals(user2.getPassword()) &&
                user1.getUsername().equals(user2.getUsername());
    }

    @Override
    public void run() {
        // TODO: Implement this with your business logic
        User user = mUserRepository.get("plop");

        if (credentialsOk(user,mUser)) {
//            mUserRepository.update(mUser);
            postMessage(user);
            return;
        }

        notifyError();
    }
}
