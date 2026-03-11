package assessment.week3.task5.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String courseName;
    private String instructor;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments;

    public Course() {}

    public Course(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public List<Enrollment> getEnrollments() { return enrollments; }
    public void setEnrollments(List<Enrollment> enrollments) { this.enrollments = enrollments; }
}