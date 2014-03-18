package controllerANDview;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Employer;
import model.StreamClass;
import model.Vacancy;


public class Controller {

	public static void main(String[] args) throws ParseException {
		StreamClass.readVacancy();
		begin();
	}
	/**
	 * Реализация пользовательского интерфейса и доступа к методам манипуляции с данными
	 */
	static void begin()
	{
		try
		{
		Controller cont = new Controller();
		System.out.println("Please choose the action:"
				+ "\r\n"+"1 - Add"
				+ "\r\n"+"2 - View"
				+ "\r\n"+"3 - Edit"
				+ "\r\n"+"4 - Delete"
				+ "\r\n"+"5 - Find vacancy");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch(choose)
		{
		case 1:
			cont.addVacancy();
			break;
		case 2:
			cont.viewVacancy();
			break;
		case 3:
			cont.editVacancy();
			break;
		case 4:
			cont.deleteFromVacancy();
			break;
		case 5:
			cont.findVacancy();
			break;
			default:
				begin();
		}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter correct number");
			begin();
		}
			
	}
	/**
	 * Добавление вакансии
	 */
	void addVacancy()
	{
		try
		{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employer name:");
		String name = sc.nextLine();
		System.out.println("Enter employer address:");
		String address = sc.nextLine();
		System.out.println("Enter employer phone number:");
		String number = sc.nextLine();
		Employer newEmployer = new Employer(name,address,number);
		System.out.println("Enter vacancy name:");
		String vName = sc.nextLine();
		System.out.println("Enter salary of vacancy:");
		double salary = Double.parseDouble(sc.nextLine());
		System.out.println("Enter date of registration:");
		Date date = StreamClass.df.parse(sc.nextLine());
		Vacancy newVacancy = new Vacancy(vName,salary,date,newEmployer);
		System.out.println("You just add: "+newVacancy.toString());
		StreamClass.writeVacancy();
		StreamClass.readVacancy();
		}
		catch(ParseException e)
		{
			System.out.println("Date is incorrect");
		}
		finally
		{
		begin();
		}
	}
	/**
	 * Просмотр всех вакансий
	 */
	void viewVacancy()
	{
		for(int i =0;i<Vacancy.vacancyArr.size();i++)
		{
			System.out.println(Vacancy.vacancyArr.get(i).toString());
		}
		begin();
	}
	/**
	 * Изменение вакансий
	 */
	void editVacancy()
	{
		
		StreamClass.readVacancy();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter name of Employer which you want to edit");
		String name = sc.nextLine();
		try
		{
		System.out.println("Please enter vacancy date of registration");
		Date dateR =StreamClass.df.parse(sc.nextLine());
		int numberOfEmployer=-1;
		for (int i =0;i<Vacancy.vacancyArr.size();i++)
		{
			if(Vacancy.vacancyArr.get(i).getEmployer().getEmployerCompanyName().equals(name) && Vacancy.vacancyArr.get(i).getDateOfRegistration().equals(dateR) )
			{
				System.out.println("You edit:"+Vacancy.vacancyArr.get(i).toString());
				numberOfEmployer=i;
				System.out.println("Enter employer name:");
				String name1 = sc.nextLine();
				System.out.println("Enter employer address:");
				String address = sc.nextLine();
				System.out.println("Enter employer phone number:");
				String number = sc.nextLine();
				Vacancy.vacancyArr.get(numberOfEmployer).getEmployer().setEmployerCompanyName(name1);
				Vacancy.vacancyArr.get(numberOfEmployer).getEmployer().setEmployerCompanyAddress(address);
				Vacancy.vacancyArr.get(numberOfEmployer).getEmployer().setEmployerCompatyPhone(number);
				System.out.println("Enter vacancy name:");
				String vName = sc.nextLine();
				System.out.println("Enter salary:");
				double salary = Double.parseDouble(sc.nextLine());
				System.out.println("Enter date of registration:");
				Date date = StreamClass.df.parse(sc.nextLine());
				Vacancy.vacancyArr.get(numberOfEmployer).setVacancyName(vName);
				Vacancy.vacancyArr.get(numberOfEmployer).setVacansySalary(salary);
				Vacancy.vacancyArr.get(numberOfEmployer).setDateOfRegistration(date);
				System.out.println("Edited Vacancy: "+Vacancy.vacancyArr.get(numberOfEmployer).toString());
				StreamClass.writeVacancy();
				StreamClass.readVacancy();
				begin();
			}
		}
			System.out.println("That Employer is not exist!");
			begin();
		}
		catch(ParseException e)
		{
		System.out.println("Date is incorrect");	
		}
		finally
		{
			begin();
		}
	}
	/**
	 * Удаление вакансии
	 */
	void deleteFromVacancy()
	{
		try
		{
		StreamClass.readVacancy();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter name of Employer which you want to edit");
		String name = sc.nextLine();
		System.out.println("Please enter vacancy date of registration");
		Date dateR =StreamClass.df.parse(sc.nextLine());
		for (int i =0;i<Vacancy.vacancyArr.size();i++)
		{
			if(Vacancy.vacancyArr.get(i).getEmployer().getEmployerCompanyName().equals(name)&&Vacancy.vacancyArr.get(i).getDateOfRegistration().equals(dateR))
			{
				System.out.println("You just deleted:"+Vacancy.vacancyArr.get(i).toString());
				Vacancy.vacancyArr.remove(i);
				StreamClass.writeVacancy();
				StreamClass.readVacancy();
				begin();
			}
		}
			System.out.println("That Employer is not exist!");
			begin();
		}
		catch (ParseException e)
		{
			System.out.println("Incorrect date");
		}
			
	}
	/**
	 * Поиск вакансии
	 */
	void findVacancy()
	{
		try
		{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose option of finding:"
								+"\r\n"+"1-By vacancy"
								+"\r\n"+"2-By salary");
		int choose =Integer.parseInt( sc.nextLine());
		switch(choose)
		{
		case 1:
			System.out.println("Please enter speciality:");
			String speciality = sc.nextLine();
			for(int i =0;i<Vacancy.vacancyArr.size();i++)
			{
				if(Vacancy.vacancyArr.get(i).getVacancyName().equals(speciality))
				{
					System.out.println(Vacancy.vacancyArr.get(i).toString());
				}
			}
			begin();
			
			break;
		case 2:
			System.out.println("Please enter minimum salary:");
			double salary = sc.nextDouble();
			for(int i =0;i<Vacancy.vacancyArr.size();i++)
			{
				if(Vacancy.vacancyArr.get(i).getVacansySalary()>=salary)
				{
					System.out.println(Vacancy.vacancyArr.get(i).toString());
				}
			}
			begin();
			break;
			default:
				begin();
				break;
		}
		}
		catch(NumberFormatException e)
		{
			System.out.println("Please enter correct number");
			begin();
		}
}
}