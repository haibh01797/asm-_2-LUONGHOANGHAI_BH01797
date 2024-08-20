import java.awt.desktop.OpenURIEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {


    static List<student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Nhap thong tin sinh vien");
            System.out.println("2. In danh sach sinh vien");
            System.out.println("3. Xoa sinh vien theo ma code");
            System.out.println("4. Sap xep sinh vien theo diem giam dan");
            System.out.println("5. Tim kiem sinh vien theo ma code hoac ten");
            System.out.println("6. Tim kiem sinh vien theo diem >= x");
            System.out.print("Chon chuc nang: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left-over

            switch (choice) {
                case 1:
                    input();
                    break;
                case 2:
                    output();
                    break;
                case 3:
                    System.out.println("Nhap ma sv can xoa:");
                    String codeToRemove = scanner.nextLine();
                    removeByCode(codeToRemove);
                    break;
                case 4:
                    sortByGradeDesc();
                    break;
                case 5:
                    System.out.println("Nhap ma sv hoac ten sv:");
                    String keyword = scanner.nextLine();
                    student foundStudent = findByCodeOrName(keyword);
                    if (foundStudent != null) {
                        foundStudent.displayInfo();
                    } else {
                        System.out.println("Khong tim thay sinh vien.");
                    }
                    break;
                case 6:
                    System.out.println("Nhap diem >= x:");
                    float minGrade = scanner.nextFloat();
                    List<student> filteredStudents = filterByGrade(minGrade);
                    if (filteredStudents.isEmpty()) {
                        System.out.println("Khong tim thay sinh vien.");
                    } else {
                        for (student s : filteredStudents) {
                            s.displayInfo();
                        }
                    }
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }


    public static void input() {
        System.out.println("Nhap vao thong tin sinh vien:");

        System.out.println("Nhap ma sv:");
        String code = scanner.nextLine();
        System.out.println("Nhap ten sv:");
        String name = scanner.nextLine();
        System.out.println("Nhap tuoi sv:");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over
        System.out.println("Nhap email sv:");
        String email = scanner.nextLine();
        System.out.println("Nhap phone sv:");
        String phone = scanner.nextLine();
        System.out.println("Nhap gioi tinh sv (0 cho nam, 1 cho nu):");
        int gender = scanner.nextInt();
        System.out.println("Nhap diem:");
        float grade = scanner.nextFloat();
        scanner.nextLine(); // Consume the newline left-over

        student student = new student(code, name, age, email, phone, gender, grade);
        studentList.add(student);
    }


    public static void output() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sach sinh vien rong.");
        } else {
            for (student student : studentList) {
                System.out.println(student);
            }
        }
    }


    public static void removeByCode(String code) {
        boolean removed = studentList.removeIf(student -> student.getCode().equalsIgnoreCase(code));
        if (removed) {
            System.out.println("Xoa sinh vien thanh cong.");
        } else {
            System.out.println("Khong tim thay sinh vien de xoa.");
        }
    }


    public static void sortByGradeDesc() {
        studentList.sort((s1, s2) -> Float.compare(s2.getGrade(), s1.getGrade())); // Điểm giảm dần
        System.out.println("Danh sach sinh vien da duoc sap xep theo diem giam dan.");
    }

    public static student findByCodeOrName(String keyword) {
        return studentList.stream()
                .filter(student -> student.getCode().equalsIgnoreCase(keyword) || student.getName().equalsIgnoreCase(keyword))
                .findFirst()
                .orElse(null);
    }


    public static List<student> filterByGrade(float x) {
        List<student> filteredList = new ArrayList<>();
        for (student student : studentList) {
            if (student.getGrade() >= x) {
                filteredList.add(student);
            }
        }
        return filteredList;
    }
}