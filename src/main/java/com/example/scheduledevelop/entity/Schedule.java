package com.example.scheduledevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "schedule")
    private List<Comment> comments;


    public Schedule() {}

    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void updateSchedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }


}
