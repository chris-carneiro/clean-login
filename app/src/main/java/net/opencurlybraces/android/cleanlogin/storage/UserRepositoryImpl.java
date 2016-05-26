package net.opencurlybraces.android.cleanlogin.storage;

import net.opencurlybraces.android.cleanlogin.domain.model.User;
import net.opencurlybraces.android.cleanlogin.domain.repository.UserRepository;

/**
 * Created by chris on 5/25/16.
 */
public class UserRepositoryImpl implements UserRepository {
    @Override
    public boolean insert(User model) {
        return false;
    }

    @Override
    public boolean update(User model) {
        return false;
    }

    @Override
    public User get(Object id) {
        return null;
    }

    @Override
    public User get(String username) {
        User user = UserFactory.createUser(username,"Proooot");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean delete(User model) {
        return false;
    }
}
