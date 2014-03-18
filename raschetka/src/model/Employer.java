package model;

public class Employer {
private String employerCompanyName;
private String employerCompatyPhone;
private String employerCompanyAddress;
public Employer(String employerCompanyName,
		String employerCompanyAddress, String employerCompatyPhone) {
	super();
	this.employerCompanyName = employerCompanyName;
	this.employerCompatyPhone = employerCompatyPhone;
	this.employerCompanyAddress = employerCompanyAddress;
}public Employer()
{
	
}
public String getEmployerCompanyName() {
	return employerCompanyName;
}
public void setEmployerCompanyName(String employerCompanyName) {
	this.employerCompanyName = employerCompanyName;
}
public String getEmployerCompatyPhone() {
	return employerCompatyPhone;
}
public void setEmployerCompatyPhone(String employerCompatyPhone) {
	this.employerCompatyPhone = employerCompatyPhone;
}
public String getEmployerCompanyAddress() {
	return employerCompanyAddress;
}
public void setEmployerCompanyAddress(String employerCompanyAddress) {
	this.employerCompanyAddress = employerCompanyAddress;
}
@Override
public String toString() {
	return "Employer [employerCompanyName=" + employerCompanyName
			+ ", employerCompatyPhone=" + employerCompatyPhone
			+ ", employerCompanyAddress=" + employerCompanyAddress + "]";
}


}
