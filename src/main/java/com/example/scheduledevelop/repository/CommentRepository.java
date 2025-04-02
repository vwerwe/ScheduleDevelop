package com.example.scheduledevelop.repository;

import com.example.scheduledevelop.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository <Comment, Long> {

    List<Comment> findByScheduleId(Long scheduleId);

}
