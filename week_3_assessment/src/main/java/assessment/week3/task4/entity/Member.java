package assessment.week3.task4.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String membershipType;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Workout> workouts;

    public Member() {}

    public Member(String name, String membershipType) {
        this.name = name;
        this.membershipType = membershipType;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }

    public List<Workout> getWorkouts() { return workouts; }
    public void setWorkouts(List<Workout> workouts) { this.workouts = workouts; }
}