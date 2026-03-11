package assessment.week3.task4.entity;

import jakarta.persistence.*;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String exerciseName;
    private int duration;
    private String workoutDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Workout() {}

    public Workout(String exerciseName, int duration, String workoutDate, Member member) {
        this.exerciseName = exerciseName;
        this.duration = duration;
        this.workoutDate = workoutDate;
        this.member = member;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getExerciseName() { return exerciseName; }
    public void setExerciseName(String exerciseName) { this.exerciseName = exerciseName; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getWorkoutDate() { return workoutDate; }
    public void setWorkoutDate(String workoutDate) { this.workoutDate = workoutDate; }

    public Member getMember() { return member; }
    public void setMember(Member member) { this.member = member; }
}