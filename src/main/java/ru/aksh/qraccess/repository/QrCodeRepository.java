package ru.aksh.qraccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.aksh.qraccess.domain.QrCode;

import java.util.UUID;

@Repository
public interface QrCodeRepository extends JpaRepository<QrCode, UUID> {

    @Modifying
    @Query(value = "UPDATE qr_code SET qr_uuid = :newUuid WHERE qr_uuid = :oldUuid", nativeQuery = true)
    void updateQrCode(@Param("oldUuid") UUID oldUuid, @Param("newUuid") UUID newUuid);
}
