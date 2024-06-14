package me.jincrates.domain.core.entity;

public record Customer(
    Long id,
    String name,
    String mobileNo
) {

    public Customer {
        if (id == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        if (mobileNo == null) {
            throw new IllegalArgumentException("mobileNo must not be null");
        }

        // validate
        if (mobileNo.length() > 11) {
            throw new IllegalArgumentException("mobileNo length must be less than 11");
        }
    }
}
