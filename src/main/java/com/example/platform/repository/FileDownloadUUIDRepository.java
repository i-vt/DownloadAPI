package com.example.platform.repository;

import com.example.platform.model.FileDownloadUUID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDownloadUUIDRepository extends JpaRepository<FileDownloadUUID, String> {
    Optional<FileDownloadUUID> findByUuidAndUsedFalse(String uuid);
}
