public class Passenger {

    private int id;
    private boolean survived;
    private int pClass;
    private String name;
    private String sex;
    private double age;
    private int sibSp;
    private int parch;
    private String ticket;
    private double fare;
    private String cabin;
    private String embarked;


    public String getFormattedName() {

        String firstName = name.substring(name.indexOf("."));
        firstName = firstName.substring(2);
        String[] splitName2 = name.split(",");
        String lastName = splitName2[0];
        return firstName + " " + lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurvived(boolean survived) {
        this.survived = survived;
    }

    public void setpClass(int pClass) {
        this.pClass = pClass;
    }

    public int getId() {
        return id;
    }

    public boolean isSurvived() {
        return survived;
    }

    public int getpClass() {
        return pClass;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public double getAge() {
        return age;
    }

    public int getSibSp() {
        return sibSp;
    }

    public int getParch() {
        return parch;
    }

    public String getTicket() {
        return ticket;
    }

    public double getFare() {
        return fare;
    }

    public String getCabin() {
        return cabin;
    }

    public String getEmbarked() {
        return embarked;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setSibSp(int sibSp) {
        this.sibSp = sibSp;
    }

    public void setParch(int parch) {
        this.parch = parch;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public void setEmbarked(String embarked) {
        this.embarked = embarked;
    }
}
