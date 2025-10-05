package ru.aksh.qraccess.service;

import ru.aksh.qraccess.model.response.UserResponse;

import java.util.UUID;

public interface QrCodeService {
    UserResponse getUserAndUpdateQrCode(UUID uuid);
}
