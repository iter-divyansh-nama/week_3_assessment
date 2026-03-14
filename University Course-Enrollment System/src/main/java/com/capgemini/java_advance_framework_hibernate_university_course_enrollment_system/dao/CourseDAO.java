package com.capgemini.java_advance_framework_hibernate_university_course_enrollment_system.dao;



import jakarta.persistence.*;
import java.time.LocalDate;

import com.capgemini.java_advance_framework_hibernate_university_course_enrollment_system.entity.Course;
import com.capgemini.java_advance_framework_hibernate_university_course_enrollment_system.entity.Enrollment;

public class CourseDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("course");

    public void addCourse(String courseName, String instructor,
                          String studentName, String date) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            Course course = new Course();
            course.setCourseName(courseName);
            course.setInstructor(instructor);

            Enrollment enrollment = new Enrollment();
            enrollment.setStudentName(studentName);
            enrollment.setEnrollmentDate(LocalDate.parse(date));

            course.addEnrollment(enrollment);

            em.persist(course);

            tx.commit();

            System.out.println("Course added successfully");

        } catch (Exception e) {

            tx.rollback();
            System.out.println("Invalid enrollment date");

        }

        em.close();
    }

    public void searchCourse(int id) {

        EntityManager em = emf.createEntityManager();

        Course c = em.find(Course.class, id);

        if (c == null) {
            System.out.println("Course not found");
            return;
        }

        System.out.println("ID: " + c.getId());
        System.out.println("Course: " + c.getCourseName());
        System.out.println("Instructor: " + c.getInstructor());
        System.out.println("Enrollments:");

        for (Enrollment e : c.getEnrollments()) {

            System.out.println("  Student Name: " + e.getStudentName());
            System.out.println("  Enrollment Date: " + e.getEnrollmentDate());

        }

        em.close();
    }

    public void updateEnrollment(int courseId, int enrollmentId, String newDate) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Query q = em.createQuery(
                "UPDATE Enrollment e SET e.enrollmentDate = :d " +
                        "WHERE e.id = :eid AND e.course.id = :cid");

        q.setParameter("d", LocalDate.parse(newDate));
        q.setParameter("eid", enrollmentId);
        q.setParameter("cid", courseId);

        int updated = q.executeUpdate();

        tx.commit();

        if (updated > 0)
            System.out.println("Enrollment updated successfully");
        else
            System.out.println("Enrollment not found");

        em.close();
    }

    public void deleteCourse(int id) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Course c = em.find(Course.class, id);

        if (c != null) {

            em.remove(c);
            System.out.println("Course deleted successfully");

        } else {

            System.out.println("Course not found");

        }

        tx.commit();
        em.close();
    }
}