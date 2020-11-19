import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
//        чтение с консоли и создание объекта персон
        Scanner scan = new Scanner(System.in);
        System.out.println("введите данные человека");
        Person person = getPerson(scan.nextLine());
        // подъсчёт дня недели
        String dayOfWeek;// строчное отображение дня недели
        dayOfWeek =String.format(" %tA " ,nextBirthday(person.getDateOfBorn()));
        // Creating File
        File fileName = new File("C://42t_java//personWithDays.txt");
        try (FileWriter fw = new FileWriter(fileName)){
            fw.write(person.toString()+dayOfWeek);
        }
    }
    public static Person getPerson (String line) throws ParseException {
        String[] arrayPerson = line.split(" ");
        String firstName = arrayPerson[0];
        String name = arrayPerson[1];
        String patronymic = arrayPerson[2];
        String strdateOfBorn = arrayPerson[3].replaceAll("\\p{Punct}",",");
        DateFormat dateFormat = new SimpleDateFormat("dd,MM,yyyy");
        return new Person(firstName,name,patronymic,dateFormat.parse(strdateOfBorn),getAge(strdateOfBorn),
                dayeBetwenBirthday(dateFormat.parse(strdateOfBorn)),nextBirthday(dateFormat.parse(strdateOfBorn)));
    }
    public static int getAge(String birthday){
        String[] strBirthday = birthday.split(",");
        String day = strBirthday[0];
        String month = strBirthday[1];
        String year = strBirthday[2];
        LocalDate dateNow = LocalDate.now();
        LocalDate birthdaydate = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
        return (int) ChronoUnit.YEARS.between(birthdaydate,dateNow);
    }
    public static int dayeBetwenBirthday (Date birthdate){
        LocalDate dateNow = LocalDate.now();
        String[] strBirthdays = String.format("%tF",nextBirthday(birthdate)).split("-");
        int day = Integer.parseInt(strBirthdays[2].trim());
        int month = Integer.parseInt(strBirthdays[1].trim());
        int year = Integer.parseInt(strBirthdays[0].trim());

        return Math.abs((int)ChronoUnit.DAYS.between(LocalDate.of(year,month,day),dateNow));
    }

    public static Date nextBirthday (Date birthday){
        String[] birtdayStr = String.format("%tF",birthday).split("-");
        int year = Integer.parseInt(birtdayStr[0].trim());
        int month = Integer.parseInt(birtdayStr[1].trim());
        int day= Integer.parseInt(birtdayStr[2].trim());

        Date dateNow = new Date();
        String[] dateNowStr = String.format("%tF",dateNow).split("-");
        int yearnow = Integer.parseInt(dateNowStr[0].trim());
        int monthnow = Integer.parseInt(dateNowStr[1].trim());
        int daynow= Integer.parseInt(dateNowStr[2].trim());

        if ((monthnow >= month && daynow >= day) || (monthnow > month && daynow <= day) ){
            return new GregorianCalendar(yearnow+1,month-1,day).getTime();
        }
        else return new GregorianCalendar(yearnow,month-1,day).getTime();
    }
}
