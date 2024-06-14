package me.jincrates.domain.core.entity;

public record User(
    Long id,
    String name,
    String mobileNo
) {

    public User {
        if (id == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        if (mobileNo == null) {
            throw new IllegalArgumentException("mobileNo must not be null");
        }

        // mobileNo validate
    }

}
