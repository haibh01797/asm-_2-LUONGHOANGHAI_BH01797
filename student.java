public class student {
    private String code;
    private String name;
    private int age;
    private String email;
    private String phone;
    private int gender;
    private float grade;


    public student(String code, String name, int age, String email, String phone, int gender, float grade) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.grade = grade;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }


    public void displayInfo() {
        System.out.println("Code: " + code);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Gender: " + (gender == 0 ? "Male" : "Female"));
        System.out.println("Grade: " + grade);

    }

    public static void main(String[] args) {
        // Creating a Student object
        student student = new student("S2005","hai", 20, "hai@gamil.com", "123-456-7890", 0,  3.5f);


        student.displayInfo();
    }

}
