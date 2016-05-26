package net.opencurlybraces.android.cleanlogin.domain.interactors;


import net.opencurlybraces.android.cleanlogin.domain.interactors.base.Interactor;
import net.opencurlybraces.android.cleanlogin.domain.model.User;

public interface LoginInteractor extends Interactor {

    interface Callback {
        // TODO: Add interactor callback methods here
        void onClickLogin(String username, String password);
        void logUserIn(User user);
        void onLoginSuccess(User user);
        void onLoginError(String error);
    }

    // TODO: Add interactor methods here
}
