public class Student {
    private static final String country = "Kenya";
    private String name = "peter";
    private int age = 20;

    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getStudentName(){
        return name;
    }

    public static String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    private int getComputedAge(){
        if (name!=null && !name.isEmpty()){
            age = name.length()*country.length()+10;
        }
        return age;
    }
}
