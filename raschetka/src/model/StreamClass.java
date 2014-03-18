package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class StreamClass {
public static final DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
public static final String VacancyAddress = "Vacancy.txt";
/**
 * Запись вакансии в текстовый файл
 */
public static void writeVacancy()
{
	File file = new File(VacancyAddress);
    try {
        if(!file.exists()){
            file.createNewFile();
        }
        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
 
        try {
        	for (int i = 0;i<Vacancy.vacancyArr.size();i++)
        	{
        		if(i==0)
        		{
        		out.print("\n"+Vacancy.vacancyArr.get(i).getEmployer().getEmployerCompanyName());
        		out.print("\r\n"+Vacancy.vacancyArr.get(i).getEmployer().getEmployerCompanyAddress());
        		out.print("\r\n"+Vacancy.vacancyArr.get(i).getEmployer().getEmployerCompatyPhone());
        		out.print("\r\n"+Vacancy.vacancyArr.get(i).getVacancyName());
        		out.print("\r\n"+Vacancy.vacancyArr.get(i).getVacansySalary());
        		out.print("\r\n"+df.format(Vacancy.vacancyArr.get(i).getDateOfRegistration()));
        		}
        		else
        		{
        			out.print("\r\n"+Vacancy.vacancyArr.get(i).getEmployer().getEmployerCompanyName());
            		out.print("\r\n"+Vacancy.vacancyArr.get(i).getEmployer().getEmployerCompanyAddress());
            		out.print("\r\n"+Vacancy.vacancyArr.get(i).getEmployer().getEmployerCompatyPhone());
            		out.print("\r\n"+Vacancy.vacancyArr.get(i).getVacancyName());
            		out.print("\r\n"+Vacancy.vacancyArr.get(i).getVacansySalary());
            		out.print("\r\n"+df.format(Vacancy.vacancyArr.get(i).getDateOfRegistration()));
        		}
        		
        	}
        } finally {

            out.close();
        }
    } catch(IOException e) {
       System.out.println("ERROR:Problems with file!");
    }

}
/**
 * Чтение вакансии с текстового файла
 */
public static  void readVacancy ()
{
	File myFile = new File (VacancyAddress);
	FileReader fileReader;
	try {
		fileReader = new FileReader(myFile);
		BufferedReader reader = new BufferedReader(fileReader);
		String line = null;
		ArrayList<String> all = new ArrayList<String>();
		reader.read();
		while ((line=reader.readLine()) !=null)
		{
			all.add(line);
		}
		reader.read();
		if(all.size()>0)
		{
		ArrayList<Vacancy> newVacancy = new ArrayList<Vacancy>();
		for (int i=0;i<all.size();i++)
		{
			if(i % 6==0)
			{
				Employer newE = new Employer();
				newE.setEmployerCompanyName(all.get(i));
				newE.setEmployerCompanyAddress(all.get(i+1));
				newE.setEmployerCompatyPhone(all.get(i+2));
				Vacancy newV = new Vacancy();
				newV.setEmployer(newE);
				newV.setVacancyName(all.get(i+3));
				newV.setVacansySalary(Double.parseDouble(all.get(i+4)));
				newV.setDateOfRegistration(df.parse(all.get(i+5)));
				newVacancy.add(newV);
			}
		}
		Vacancy.vacancyArr = newVacancy;
		}
		else
		{
			System.out.println("DB is empty!");
		}
	} 
	catch (FileNotFoundException e) {
		 System.out.println("ERROR:File not found");
	} catch (IOException e) {
		System.out.println("ERROR:Problems with file!");
	}
	catch (ParseException e) {

	e.printStackTrace();
	}
}
}
