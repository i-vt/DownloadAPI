package com.example.platform.model;

import jakarta.persistence.*;

@Entity
public class FileDownloadUUID {

    @Id
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "file_id")
    private FileEntity file;  // FileEntity reference

    private boolean used = false;

    // Constructors
    public FileDownloadUUID() {
        this.uuid = java.util.UUID.randomUUID().toString();
    }

    // Getters and Setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public FileEntity getFile() {
        return file;  // Ensure this method exists
    }

    public void setFile(FileEntity file) {
        this.file = file;  // Ensure this method exists
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public void markUsed() {
        this.used = true;
    }
}
