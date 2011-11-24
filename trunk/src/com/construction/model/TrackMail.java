package com.construction.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@SuppressWarnings("serial")
@Entity
@Table(name = "track_mail", catalog = "emailmarketing")
public class TrackMail implements Serializable {

	private Long trackEmailId;
	private Integer userId;
	private String listEmailFile;
	private String subject;
	private Timestamp trackDate;
	private String emailContentFile;
	private String emailContentText;

	@Basic
	@Id
	@GeneratedValue
	@Column(name = "track_email_id")
		public Long getTrackEmailId() {
		return trackEmailId;
	}
	public void setTrackEmailId(Long trackEmailId) {
		this.trackEmailId = trackEmailId;
	}

	@Basic
	@Column(name = "user_id")
		public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Basic
	@Column(name = "list_email_file", length = 255)
		public String getListEmailFile() {
		return listEmailFile;
	}
	public void setListEmailFile(String listEmailFile) {
		this.listEmailFile = listEmailFile;
	}

	@Basic
	@Column(name = "subject", length = 255)
		public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Basic
	@Column(name = "track_date")
		public Timestamp getTrackDate() {
		return trackDate;
	}
	public void setTrackDate(Timestamp trackDate) {
		this.trackDate = trackDate;
	}

	@Basic
	@Column(name = "email_content_file", length = 255)
		public String getEmailContentFile() {
		return emailContentFile;
	}
	public void setEmailContentFile(String emailContentFile) {
		this.emailContentFile = emailContentFile;
	}

	@Basic
	@Column(name = "email_content_text", length = 255)
		public String getEmailContentText() {
		return emailContentText;
	}
	public void setEmailContentText(String emailContentText) {
		this.emailContentText = emailContentText;
	}



}