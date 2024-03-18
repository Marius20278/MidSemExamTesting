package view;
import controller.DepartmentDao;
import controller.SemesterDao;
import controller.StudentDAO;
import controller.StudentRegistrationDao;
import model.Department;
import model.Semester;
import model.Student;
import model.StudentRegistration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date; // Import Date class

public class Main {
    public static void main(String[] args) {
        boolean condition = true;
        StudentDAO studentDAO = new StudentDAO();
        SemesterDao semesterDao = new SemesterDao();
        DepartmentDao departmentDao = new DepartmentDao();
        StudentRegistrationDao studentRegistrationDao = new StudentRegistrationDao();
        Scanner scanner = new Scanner(System.in);

        while (condition) {
            System.out.println("Student Registration System.");
            System.out.println("____________________________");
            System.out.println("1. To save a student ");
            System.out.println("2. To Create a semester ");
            System.out.println("3. To do registration ");
            System.out.println("4. To get list of student per semester");
            System.out.println("5. insert department");
            System.out.println("6 . to view the list student per semester and department.");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter student's first name:");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter student's last name:");
                    String lastName = scanner.nextLine();
                    System.out.println("Enter student's date of birth (yyyy-MM-dd):");
                    String dobString = scanner.nextLine();
                    Date dateOfBirth;
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        dateOfBirth = dateFormat.parse(dobString);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
                        continue;
                    }
                    Student student = new Student();
                    student.setFirstName(firstName);
                    student.setLastName(lastName);
                    student.setDateOfBirth(dateOfBirth);
                    studentDAO.saveStudent(student);
                    break;

                case 2:
                    System.out.println("Enter semester name:");
                    String semesterName = scanner.nextLine();
                    System.out.println("Enter semester end date (yyyy-MM-dd):");
                    String endDateString = scanner.nextLine();
                    Date endDate;
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        endDate = dateFormat.parse(endDateString);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
                        continue;
                    }
                    Semester semester = new Semester();
                    semester.setSemesterName(semesterName);
                    semester.setEndDate(endDate);
                    semesterDao.saveSemester(semester);
                    break;

                case 3:
                    System.out.println("Enter student registration code:");
                    String registrationCode = scanner.nextLine();
                    System.out.println("Enter registration date (yyyy-MM-dd):");
                    String registrationDateString = scanner.nextLine();
                    Date registrationDate;
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        registrationDate = dateFormat.parse(registrationDateString);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
                        continue;
                    }
                    System.out.println("Enter student ID:");
                    Long studentId = scanner.nextLong();
                    System.out.println("Enter semester ID:");
                    Long semesterId = scanner.nextLong();
                    System.out.println("Enter department ID:");
                    Long departmentId = scanner.nextLong();


                    StudentRegistration studentRegistration = new StudentRegistration();
                    studentRegistration.setRegistrationCode(registrationCode);
                    studentRegistration.setRegistrationDate(registrationDate);

                    studentRegistration.setStudent(studentDAO.getStudentById(studentId));

                    studentRegistration.setSemester(semesterDao.getSemesterById(semesterId));
                    studentRegistration.setDepartment(departmentDao.getDepartmentById(departmentId));

                    studentRegistrationDao.studentRegistration(studentRegistration);
                    break;
                case 4:
                    System.out.println("Enter semester ID:");
                    long semeId = scanner.nextLong();
                    List <Student> students = studentRegistrationDao.getStudentsPerSemester(semeId);
                    if (students != null && !students.isEmpty()) {
                        System.out.println("Students registered in the semester:");
                        for (Student stud : students) {
                            System.out.println(stud.getFirstName() + " " + stud.getLastName());
                        }
                    } else {
                        System.out.println("No students found for the specified semester.");
                    }
break;
                case 5:
                    System.out.println("Enter department Id:");
                    long departId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter department name:");
                    String departName = scanner.nextLine();

                    Department department = new Department();
                   department.setDepartmentId(departId);
                  department.setDepartmentName(departName);
                  departmentDao.saveDepartment(department);
                    break;

                case 6:
                    System.out.println("Enter department Id:");
                    int depaId = scanner.nextInt();
                    System.out.println("Enter semester Id:");
                    int semestaId = scanner.nextInt();
                    List<Student> stud = studentRegistrationDao.getStudentsByDepartmentAndSemester(depaId, semestaId);
                    if (stud.isEmpty()) {
                        System.out.println("No students found for the provided department and semester.");
                    } else {
                        System.out.println("Department Name\tSemester Name\tStudent Name");
                        for (Student std : stud) {
                            System.out.println("Student per semester and department");
                            System.out.println(std.getFirstName() + " " + std.getLastName());
                        }
                    }

break;
            default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
        scanner.close();
    }
}



