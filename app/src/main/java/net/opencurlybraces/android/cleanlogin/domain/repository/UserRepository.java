package net.opencurlybraces.android.cleanlogin.domain.repository;

import net.opencurlybraces.android.cleanlogin.domain.model.User;

/**
 * A sample repository with CRUD operations on a model.
 */
public interface UserRepository {

    boolean insert(User model);

    boolean update(User model);

    User get(Object id);
    User get(String username);

    boolean delete(User model);
}
