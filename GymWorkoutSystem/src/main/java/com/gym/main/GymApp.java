package com.gym.main;

import javax.persistence.*;
import com.gym.entity.*;

import java.time.LocalDate;
import java.util.Scanner;

public class GymApp {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gymPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n1 Add Member");
            System.out.println("2 Search Member");
            System.out.println("3 Update Workout Duration");
            System.out.println("4 Delete Member");
            System.out.println("5 Exit");

            int choice = sc.nextInt();

            switch(choice) {

                // ADD MEMBER
                case 1:

                    System.out.println("Enter name membershipType exercise duration date");

                    String name = sc.next();
                    String membership = sc.next();
                    String exercise = sc.next();
                    int duration = sc.nextInt();
                    String date = sc.next();

                    tx.begin();

                    Member member = new Member(name, membership);

                    Workout workout = new Workout(
                            exercise,
                            duration,
                            LocalDate.parse(date)
                    );

                    member.addWorkout(workout);

                    em.persist(member);

                    tx.commit();

                    System.out.println("Member added successfully");

                    break;

                // SEARCH MEMBER
                case 2:

                    System.out.println("Enter Member ID");

                    int id = sc.nextInt();

                    Member m = em.find(Member.class, id);

                    if(m != null) {

                        System.out.println("ID: " + m.getId());
                        System.out.println("Name: " + m.getName());
                        System.out.println("Membership: " + m.getMembershipType());

                        System.out.println("Workouts:");

                        for(Workout w : m.getWorkouts()) {

                            System.out.println("Exercise: " + w.getExerciseName());
                            System.out.println("Duration: " + w.getDuration());
                            System.out.println("Date: " + w.getWorkoutDate());

                        }

                    } else {

                        System.out.println("Member not found");

                    }

                    break;

                // UPDATE WORKOUT
                case 3:

                    System.out.println("Enter workout ID");

                    int wid = sc.nextInt();

                    System.out.println("Enter new duration");

                    int newDuration = sc.nextInt();

                    tx.begin();

                    Workout w = em.find(Workout.class, wid);

                    if(w != null) {

                        w.setDuration(newDuration);

                        em.merge(w);

                        System.out.println("Workout updated successfully");

                    } else {

                        System.out.println("Workout not found");

                    }

                    tx.commit();

                    break;

                // DELETE MEMBER
                case 4:

                    System.out.println("Enter Member ID");

                    int deleteId = sc.nextInt();

                    tx.begin();

                    Member del = em.find(Member.class, deleteId);

                    if(del != null) {

                        em.remove(del);

                        System.out.println("Member deleted successfully");

                    } else {

                        System.out.println("Member not found");

                    }

                    tx.commit();

                    break;

                case 5:

                    em.close();
                    emf.close();

                    System.exit(0);

            }
        }
    }
}