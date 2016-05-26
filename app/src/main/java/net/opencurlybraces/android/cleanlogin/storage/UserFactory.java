package net.opencurlybraces.android.cleanlogin.storage;

import net.opencurlybraces.android.cleanlogin.domain.model.User;

/**
 * Created by chris on 5/25/16.
 */
public final class UserFactory  {

   public static final User createUser(String username, String password) {
       User user = new User(username,password);
       user.setLogged(true);
       return user;
   }
}
