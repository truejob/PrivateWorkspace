package model;

import java.util.ArrayList;
import java.util.Date;

public class Vacancy {
	private String vacancyName;
	private double vacansySalary;
	private Date dateOfRegistration;
	private Employer employer;
	public static ArrayList<Vacancy> vacancyArr = new ArrayList<Vacancy>();
	public Vacancy(String vacancyName, double vacansySalary,
			Date dateOfRegistration, Employer employer) {
		super();
		this.vacancyName = vacancyName;
		this.vacansySalary = vacansySalary;
		if(dateOfRegistration.after(new Date()))
		{
			System.out.println("Date is incorrect");
		}
		else
		{
			this.dateOfRegistration = dateOfRegistration;	
		}

		this.employer = employer;
		this.vacancyArr.add(this);
	}
	
	public Vacancy()
	{
		
	}

	public String getVacancyName() {
		return vacancyName;
	}

	public void setVacancyName(String vacancyName) {
		this.vacancyName = vacancyName;
	}

	public double getVacansySalary() {
		return vacansySalary;
	}

	public void setVacansySalary(double vacansySalary) {
	this.vacansySalary=vacansySalary;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		if(dateOfRegistration.after(new Date()))
		{
			System.out.println("Date is incorrect");
		}
		else
		{
			this.dateOfRegistration = dateOfRegistration;	
		}
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	@Override
	public String toString() {
		return "Vacancy [vacancyName=" + vacancyName + ", vacansySalary="
				+ vacansySalary + ", dateOfRegistration=" + StreamClass.df.format(dateOfRegistration)
				+ ", employer=" + employer + "]";
	}
	
}
