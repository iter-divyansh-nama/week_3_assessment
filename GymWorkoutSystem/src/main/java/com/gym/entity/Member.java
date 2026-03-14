package com.gym.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Member {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String name;
private String membershipType;

@OneToMany(mappedBy="member", cascade=CascadeType.ALL)
private List<Workout> workouts = new ArrayList<>();

public Member(){}

public Member(String name,String membershipType){
this.name=name;
this.membershipType=membershipType;
}

public int getId(){
return id;
}

public String getName(){
return name;
}

public String getMembershipType(){
return membershipType;
}

public List<Workout> getWorkouts(){
return workouts;
}

public void addWorkout(Workout workout){
workouts.add(workout);
workout.setMember(this);
}
}