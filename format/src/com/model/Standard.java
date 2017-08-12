package com.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Standard {
    private Integer id;

    private String title;

    private String url;

    private String aId;

    private Date updatetime;
    
    private MultipartFile document;

    public MultipartFile getDocument() {
		return document;
	}

	public void setFile(MultipartFile document) {
		this.document = document;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

	@Override
	public String toString() {
		return "Standard [id=" + id + ", title=" + title + ", url=" + url + ", aId=" + aId + ", updatetime="
				+ updatetime + ", document=" + document + "]";
	}
}