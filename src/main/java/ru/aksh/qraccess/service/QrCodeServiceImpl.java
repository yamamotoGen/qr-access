package ru.aksh.qraccess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aksh.qraccess.domain.QrCode;
import ru.aksh.qraccess.domain.User;
import ru.aksh.qraccess.exception.QrCodeNotFoundException;
import ru.aksh.qraccess.mapper.UserMapper;
import ru.aksh.qraccess.model.response.UserResponse;
import ru.aksh.qraccess.repository.QrCodeRepository;

import java.util.UUID;

@Service
public class QrCodeServiceImpl implements QrCodeService {
    private final QrCodeRepository qrCodeRepository;
    private final UserMapper userMapper;

    @Autowired
    public QrCodeServiceImpl(QrCodeRepository qrCodeRepository, UserMapper userMapper) {
        this.qrCodeRepository = qrCodeRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserResponse getUserAndUpdateQrCode(UUID uuid) {
        QrCode currentQrCode = qrCodeRepository.findByUuid(uuid)
                .orElseThrow(() -> new QrCodeNotFoundException("QrCode not found"));

        User user = currentQrCode.getUser();
        currentQrCode.setUuid(UUID.randomUUID());
        qrCodeRepository.save(currentQrCode);

        return userMapper.toUserResponse(user);
    }
}
