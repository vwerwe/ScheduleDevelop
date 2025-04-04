package com.example.scheduledevelop.repository;

import com.example.scheduledevelop.dto.responseDto.PageResponseDto;
import com.example.scheduledevelop.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {


    default Schedule findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }


    @Query("""
        SELECT new com.example.scheduledevelop.dto.responseDto.PageResponseDto(s.id, s.title, s.contents, COUNT(c), s.createdAt, s.modifiedAt, u.username)
        FROM Schedule s LEFT JOIN s.comments c LEFT JOIN s.user u
        GROUP BY s.id
        ORDER BY s.modifiedAt DESC
    """)
    Page<PageResponseDto> findPageBySchedule(Pageable pageable);

}
