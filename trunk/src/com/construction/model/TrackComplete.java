package com.construction.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "track_complete", catalog = "emailmarketing")
@SuppressWarnings("serial")
public class TrackComplete implements Serializable {

	private Long trackCompleteId;
	private Long trackEmailId;
	private Long totalMail;
	private Long completeMail;
	private Long errorMail;
	private Timestamp dateFinish;


	@Basic
	@Id
	@GeneratedValue
	@Column(name = "track_complete_id")
		public Long getTrackCompleteId() {
		return trackCompleteId;
	}
	public void setTrackCompleteId(Long trackCompleteId) {
		this.trackCompleteId = trackCompleteId;
	}

	@Basic
	@Column(name = "track_email_id")
		public Long getTrackEmailId() {
		return trackEmailId;
	}
	public void setTrackEmailId(Long trackEmailId) {
		this.trackEmailId = trackEmailId;
	}

	@Basic
	@Column(name = "total_mail")
		public Long getTotalMail() {
		return totalMail;
	}
	public void setTotalMail(Long totalMail) {
		this.totalMail = totalMail;
	}

	@Basic
	@Column(name = "complete_mail")
		public Long getCompleteMail() {
		return completeMail;
	}
	public void setCompleteMail(Long completeMail) {
		this.completeMail = completeMail;
	}

	@Basic
	@Column(name = "error_mail")
		public Long getErrorMail() {
		return errorMail;
	}
	public void setErrorMail(Long errorMail) {
		this.errorMail = errorMail;
	}

	@Basic
	@Column(name = "date_finish")
		public Timestamp getDateFinish() {
		return dateFinish;
	}
	public void setDateFinish(Timestamp dateFinish) {
		this.dateFinish = dateFinish;
	}



}