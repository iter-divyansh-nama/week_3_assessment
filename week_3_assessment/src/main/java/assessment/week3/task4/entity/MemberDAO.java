package assessment.week3.task4.entity;

import jakarta.persistence.*;
import java.util.List;

public class MemberDAO {

    private EntityManagerFactory emf;

    public MemberDAO() {
        emf = Persistence.createEntityManagerFactory("assessment_week3_task4");
    }

    // ADD Member with Workout
    public void addMember(String name, String membershipType,
                          String exerciseName, int duration, String workoutDate) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Member member = new Member(name, membershipType);
        em.persist(member);

        Workout workout = new Workout(exerciseName, duration, workoutDate, member);
        em.persist(workout);

        em.getTransaction().commit();
        System.out.println("Member added successfully");

        printMember(em, member.getId());

        em.close();
    }

    // SEARCH Member by ID
    public void searchMember(int id) {
        EntityManager em = emf.createEntityManager();
        printMember(em, id);
        em.close();
    }

    // UPDATE Workout Duration
    public void updateWorkoutDuration(int memberId, int workoutId, int newDuration) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Member member = em.createQuery(
                "SELECT m FROM Member m WHERE m.id = :id", Member.class)
                .setParameter("id", memberId)
                .getResultStream().findFirst().orElse(null);

        if (member == null) {
            System.out.println("Member not found");
            em.getTransaction().rollback();
            em.close();
            return;
        }

        Workout workout = em.createQuery(
                "SELECT w FROM Workout w WHERE w.id = :id", Workout.class)
                .setParameter("id", workoutId)
                .getResultStream().findFirst().orElse(null);

        if (workout == null) {
            System.out.println("Workout not found");
            em.getTransaction().rollback();
            em.close();
            return;
        }

        workout.setDuration(newDuration);
        em.merge(member);

        em.getTransaction().commit();
        System.out.println("Workout updated successfully");
        em.close();
    }

    // DELETE Member
    public void deleteMember(int id) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Member member = em.createQuery(
                "SELECT m FROM Member m WHERE m.id = :id", Member.class)
                .setParameter("id", id)
                .getResultStream().findFirst().orElse(null);

        if (member == null) {
            System.out.println("Member not found");
            em.getTransaction().rollback();
            em.close();
            return;
        }

        em.remove(member);
        em.getTransaction().commit();
        System.out.println("Member deleted successfully");
        em.close();
    }

    // Helper: print member details
    private void printMember(EntityManager em, int id) {

        Member member = em.createQuery(
                "SELECT m FROM Member m WHERE m.id = :id", Member.class)
                .setParameter("id", id)
                .getResultStream().findFirst().orElse(null);

        if (member == null) {
            System.out.println("Member not found");
            return;
        }

        List<Workout> workouts = em.createQuery(
                "SELECT w FROM Workout w WHERE w.member.id = :id", Workout.class)
                .setParameter("id", id)
                .getResultList();

        System.out.println("ID: " + member.getId());
        System.out.println("Name: " + member.getName());
        System.out.println("Membership: " + member.getMembershipType());
        System.out.println("Workouts:");
        for (Workout w : workouts) {
            System.out.println("  Exercise: " + w.getExerciseName());
            System.out.println("  Duration: " + w.getDuration());
            System.out.println("  Date: " + w.getWorkoutDate());
        }
    }

    public void close() {
        emf.close();
    }
}