package com.example.platform.service;

import com.example.platform.model.FileEntity;
import com.example.platform.model.FileDownloadUUID;
import com.example.platform.repository.FileDownloadUUIDRepository;
import com.example.platform.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FileDownloadUUIDRepository fileDownloadUUIDRepository;

    private final String DOWNLOADS_DIRECTORY = "downloads";

    @PostConstruct
    public void init() {
        File downloadsDir = new File(DOWNLOADS_DIRECTORY);
        if (!downloadsDir.exists()) {
            throw new RuntimeException("Downloads directory does not exist");
        }

        // Scan files in the /downloads folder
        for (File file : downloadsDir.listFiles()) {
            if (file.isFile()) {
                FileEntity fileEntity = new FileEntity();
                fileEntity.setFileName(file.getName());

                List<FileDownloadUUID> downloadUUIDs = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    FileDownloadUUID fileDownloadUUID = new FileDownloadUUID();
                    fileDownloadUUID.setFile(fileEntity);
                    downloadUUIDs.add(fileDownloadUUID);
                }

                fileEntity.setDownloadUUIDs(downloadUUIDs);
                fileRepository.save(fileEntity);
            }
        }
    }

    public File getFileByUUID(String uuid) {
        FileDownloadUUID fileDownloadUUID = fileDownloadUUIDRepository
                .findByUuidAndUsedFalse(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Invalid or already used UUID"));

        fileDownloadUUID.markUsed();
        fileDownloadUUIDRepository.save(fileDownloadUUID);

        FileEntity fileEntity = fileDownloadUUID.getFile();
        return new File(DOWNLOADS_DIRECTORY + "/" + fileEntity.getFileName());
    }
}
