package model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "semester_id")
    private long semesterId;

    @Column(name = "semester_name")
    private String semesterName;

    @Column(name = "end_date")
    private Date endDate;

    public Semester() {
    }

    public Semester(long semesterId, String semesterName, Date endDate) {
        this.semesterId = semesterId;
        this.semesterName = semesterName;
        this.endDate = endDate;
    }

// Getters and setters

    public long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

