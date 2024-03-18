package model;

import jakarta.persistence.*;

    @Entity
    @Table(name = "courses")
    public class Course {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "course_id")
        private Long courseId;

        @Column(name = "course_code", nullable = false, unique = true)
        private String courseCode;

        @Column(name = "course_name", nullable = false)
        private String courseName;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "semester_id", nullable = false)
        private Semester semester;

        public Course() {
        }

        public Course(Long courseId, String courseCode, String courseName, Semester semester) {
            this.courseId = courseId;
            this.courseCode = courseCode;
            this.courseName = courseName;
            this.semester = semester;
        }

        public Long getCourseId() {
            return courseId;
        }

        public void setCourseId(Long courseId) {
            this.courseId = courseId;
        }

        public String getCourseCode() {
            return courseCode;
        }

        public void setCourseCode(String courseCode) {
            this.courseCode = courseCode;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public Semester getSemester() {
            return semester;
        }

        public void setSemester(Semester semester) {
            this.semester = semester;
        }

        // Getters and setters
    }

