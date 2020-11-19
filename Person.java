import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private final String firstName;
    private final String name;
    private final String patronymic;
    private final Date dateOfBorn;
    private final int age;
    private final int daysBetwenBirthday;
    private final Date dateOfNextBirthday;

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Date getDateOfBorn() {
        return dateOfBorn;
    }

    public int getAge() {
        return age;
    }

    public int getDaysBetwenBirthday() {
        return daysBetwenBirthday;
    }

    public Date getDateOfNextBirthday() {
        return dateOfNextBirthday;
    }

    public Person(String firstName, String name, String patronymic, Date dateOfBorn, int age , int daysBetwenBirthday,
                  Date dateOfNextBirthday) {
        this.firstName = firstName;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBorn = dateOfBorn;
        this.age = age;
        this.daysBetwenBirthday = daysBetwenBirthday;
        this.dateOfNextBirthday = dateOfNextBirthday;

    }
    public String getDateOfBurnStr(){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(getDateOfBorn());
    }
    public String getDateOfNextBirthdayStr(){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(getDateOfNextBirthday());
    }
    @Override
    public String toString() {
        return getFirstName()+" "+getName()+" "+getPatronymic()+" "+getDateOfBurnStr()+" "+getAge()+" лет"
                +getDaysBetwenBirthday()+" дней до дня рождения"+getDateOfNextBirthdayStr();
    }

}