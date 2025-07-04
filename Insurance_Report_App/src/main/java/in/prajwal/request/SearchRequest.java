package in.prajwal.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


public class SearchRequest {

	private String planName;
	private String planStatus;
	private String gender;
	private String startDate;
	private String endDate;
	
	public SearchRequest() {

		this.planName = "";
		this.planStatus = "";
		this.gender = "";
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
}
