package com.example.platform.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    @OneToMany(mappedBy = "file", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FileDownloadUUID> downloadUUIDs;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<FileDownloadUUID> getDownloadUUIDs() {
        return downloadUUIDs;
    }

    public void setDownloadUUIDs(List<FileDownloadUUID> downloadUUIDs) {
        this.downloadUUIDs = downloadUUIDs;
    }
}
