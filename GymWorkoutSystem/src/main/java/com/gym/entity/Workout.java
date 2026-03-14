package com.gym.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Workout {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String exerciseName;
private int duration;
private LocalDate workoutDate;

@ManyToOne
@JoinColumn(name="member_id")
private Member member;

public Workout(){}

public Workout(String exerciseName,int duration,LocalDate workoutDate){
this.exerciseName=exerciseName;
this.duration=duration;
this.workoutDate=workoutDate;
}

public int getId(){
return id;
}

public String getExerciseName(){
return exerciseName;
}

public int getDuration(){
return duration;
}

public LocalDate getWorkoutDate(){
return workoutDate;
}

public void setDuration(int duration){
this.duration=duration;
}

public void setMember(Member member){
this.member=member;
}
}