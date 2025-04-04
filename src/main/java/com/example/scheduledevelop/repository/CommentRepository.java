package com.example.scheduledevelop.repository;

import com.example.scheduledevelop.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository <Comment, Long> {

    List<Comment> findByScheduleId(Long scheduleId);

    Optional<Comment> findById(Long id);

    default Comment findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Does not exist id = " + id));
    }


}
