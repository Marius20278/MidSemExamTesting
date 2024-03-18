package model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "student_registration")
public class StudentRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private int registrationId;

    @Column(name = "registration_code")
    private String registrationCode;

    @Column(name = "registration_date")
    private Date registrationDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    public StudentRegistration() {
    }

    public StudentRegistration(int registrationId, String registrationCode, Date registrationDate, Student student, Semester semester, Department department) {
        this.registrationId = registrationId;
        this.registrationCode = registrationCode;
        this.registrationDate = registrationDate;
        this.student = student;
        this.semester = semester;
        this.department = department;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public StudentRegistration(int registrationId, String registrationCode, Date registrationDate, Student student, Semester semester, Department department, Course course) {
        this.registrationId = registrationId;
        this.registrationCode = registrationCode;
        this.registrationDate = registrationDate;
        this.student = student;
        this.semester = semester;
        this.department = department;
        this.course = course;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
