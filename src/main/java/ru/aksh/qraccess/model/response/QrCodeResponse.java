package ru.aksh.qraccess.model.response;

import java.util.UUID;

public class QrCodeResponse {
    private UUID uuid;
    private UserResponse user;

    public QrCodeResponse() {
    }

    public QrCodeResponse(UUID uuid, UserResponse user) {
        this.uuid = uuid;
        this.user = user;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}
