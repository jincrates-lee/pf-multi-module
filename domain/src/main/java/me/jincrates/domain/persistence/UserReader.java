package me.jincrates.domain.persistence;

import me.jincrates.domain.core.entity.User;

public interface UserReader {

    User findUser(Long userId);

    User findOrderableUser(Long userId);
}
