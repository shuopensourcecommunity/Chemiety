package cn.kastner.chemiety.domain;

import javax.persistence.*;

@Entity
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fileId;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String path;

    public enum Type {

    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
