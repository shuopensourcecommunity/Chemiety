package cn.kastner.chemiety.domain;

import javax.persistence.*;

@Entity
public class File {

    public enum Type {
        SlIDE,
        DOCUMENT,
        SHOW,
        WEBSITE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fileId;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String path;

    private Type type;

    @Column(columnDefinition = "TEXT")
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
