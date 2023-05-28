package com.demo.project.user;

public class StudentEntry {

	int id;
	String Fname;
	String Lname;
	String Susername;
	String Spassword;
	String city;
	String mailId;
	Long mobileNumber;

	public StudentEntry() {
		super();
	}

	public StudentEntry(int id, String fname, String lname, String susername, String spassword, String city,
			String mailId, Long mobileNumber) {
		super();
		this.id = id;
		Fname = fname;
		Lname = lname;
		Susername = susername;
		Spassword = spassword;
		this.city = city;
		this.mailId = mailId;
		this.mobileNumber = mobileNumber;
	}

	public StudentEntry(int id, String fname, String lname) {
		super();
		this.id = id;
		Fname = fname;
		Lname = lname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public String getSusername() {
		return Susername;
	}

	public void setSusername(String susername) {
		Susername = susername;
	}

	public String getSpassword() {
		return Spassword;
	}

	public void setSpassword(String spassword) {
		Spassword = spassword;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "StudentEntry [id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", Susername=" + Susername
				+ ", Spassword=" + Spassword + ", city=" + city + ", mailId=" + mailId + ", mobileNumber="
				+ mobileNumber + "]";
	}

}
