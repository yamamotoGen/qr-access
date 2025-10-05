package ru.aksh.qraccess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aksh.qraccess.domain.QrCode;
import ru.aksh.qraccess.domain.User;
import ru.aksh.qraccess.exception.QrCodeNotFoundException;
import ru.aksh.qraccess.model.response.UserResponse;
import ru.aksh.qraccess.repository.QrCodeRepository;

import java.util.UUID;

@Service
public class QrCodeServiceImpl implements QrCodeService {
    private final QrCodeRepository qrCodeRepository;

    @Autowired
    public QrCodeServiceImpl(QrCodeRepository qrCodeRepository) {
        this.qrCodeRepository = qrCodeRepository;
    }

    @Override
    @Transactional
    public UserResponse getUserAndUpdateQrCode(UUID uuid) {
        QrCode currentQrCode = qrCodeRepository.findById(uuid)
                .orElseThrow(() -> new QrCodeNotFoundException("QrCode not found"));

        User user = currentQrCode.getUser();
        qrCodeRepository.updateQrCode(uuid, UUID.randomUUID());
        return new UserResponse(user);
    }
}
