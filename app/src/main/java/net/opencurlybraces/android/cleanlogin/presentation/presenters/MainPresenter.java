package net.opencurlybraces.android.cleanlogin.presentation.presenters;

import net.opencurlybraces.android.cleanlogin.domain.model.User;
import net.opencurlybraces.android.cleanlogin.presentation.presenters.base.BasePresenter;
import net.opencurlybraces.android.cleanlogin.presentation.ui.BaseView;


public interface MainPresenter extends BasePresenter {

    interface View extends BaseView {
        // TODO: Add your view methods
        void onUserLogged(User user);
        void onUserLoginError(String error);
    }

    // TODO: Add your presenter methods

}
