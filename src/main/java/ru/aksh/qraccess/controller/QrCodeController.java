package ru.aksh.qraccess.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.aksh.qraccess.model.response.UserResponse;
import ru.aksh.qraccess.service.QrCodeServiceImpl;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/qr")
public class QrCodeController {
    private final QrCodeServiceImpl qrCodeService;

    @Autowired
    public QrCodeController(QrCodeServiceImpl qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @PostMapping("/check")
    public UserResponse getUserAndUpdateQrCode(@RequestParam UUID uuid) {
        return qrCodeService.getUserAndUpdateQrCode(uuid);
    }
}
