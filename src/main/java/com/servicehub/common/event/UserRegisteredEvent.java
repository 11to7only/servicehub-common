package com.servicehub.common.event;

public class UserRegisteredEvent {
    private Long userId;
    private String email;

    public UserRegisteredEvent(){
    }

    public UserRegisteredEvent(Long userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserRegisteredEvent{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                '}';
    }
}
