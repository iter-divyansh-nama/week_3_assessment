package assessment.week3.task5.entity;

import jakarta.persistence.*;

@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String studentName;
    private String enrollmentDate;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Enrollment() {}

    public Enrollment(String studentName, String enrollmentDate, Course course) {
        this.studentName = studentName;
        this.enrollmentDate = enrollmentDate;
        this.course = course;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(String enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}