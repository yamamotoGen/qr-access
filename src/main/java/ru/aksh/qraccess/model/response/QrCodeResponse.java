package ru.aksh.qraccess.model.response;

import java.util.UUID;

public class QrCodeResponse {
    private Long id;
    private UUID uuid;
    private UserResponse user;

    public QrCodeResponse() {
    }

    public QrCodeResponse(Long id, UserResponse user) {
        this.id = id;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
