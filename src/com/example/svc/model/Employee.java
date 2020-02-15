package com.example.svc.model;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 121724228376012681L;

	private Integer id;
	private String salutation;
	private String firstName;
	private String lastName;
	private Integer jobId;
	private Integer jobLocationId;
	private Boolean active;

	public Employee() {
	}

	public Employee(String salutation, String firstName, String lastName, Integer jobId, Integer jobLocationId,
			Boolean active) {
		this.salutation = salutation;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobId = jobId;
		this.jobLocationId = jobLocationId;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public Integer getJobLocationId() {
		return jobLocationId;
	}

	public void setJobLocationId(Integer jobLocationId) {
		this.jobLocationId = jobLocationId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("<<< Employee >>>").append("\n")
		.append("Id: ").append(id).append("\n")
		.append("Salutation: ").append(salutation).append("\n")
		.append("First Name: ").append(firstName).append("\n")
		.append("Last Name: ").append(lastName).append("\n")
		.append("Job Id: ").append(jobId).append("\n")
		.append("Location Id: ").append(jobLocationId).append("\n")
		.append("Status: ").append(active).append("\n");
		return sb.toString();
	}
}
