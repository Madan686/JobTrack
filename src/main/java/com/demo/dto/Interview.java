package com.demo.dto;

import java.sql.Timestamp;

public class Interview {
	private int interviewId;
	private int applicationId;
	private String round;
	private Timestamp interviewDate;
	private String mode;
	private String result;
	private String feedback;

	public Interview(int interviewId, int applicationId, String round, Timestamp interviewDate, String mode,
			String result, String feedback) {

		this.interviewId = interviewId;
		this.applicationId = applicationId;
		this.round = round;
		this.interviewDate = interviewDate;
		this.mode = mode;
		this.result = result;
		this.feedback = feedback;
	}

	public int getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getRound() {
		return round;
	}

	public void setRound(String round) {
		this.round = round;
	}

	public Timestamp getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Timestamp interviewDate) {
		this.interviewDate = interviewDate;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

}
