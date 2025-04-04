package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.responseDto.CommentResponseDto;
import com.example.scheduledevelop.entity.Comment;
import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.repository.CommentRepository;
import com.example.scheduledevelop.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;


    @Override
    public CommentResponseDto save(Long scheduleId, String contents) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        Comment comment = new Comment(contents, findSchedule);

        Comment savedComment = commentRepository.save(comment);

        return new CommentResponseDto(savedComment);
    }

    @Override
    public List<CommentResponseDto> findAll(Long scheduleId) {

        List<Comment> commentList = commentRepository.findByScheduleId(scheduleId);

        return commentList.stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }

    @Override
    public CommentResponseDto findById(Long id) {

        Comment findComment = commentRepository.findByIdOrElseThrow(id);

        return new CommentResponseDto(findComment);
    }

    @Override
    @Transactional
    public CommentResponseDto update(Long id, String contents) {

        Comment findComment = commentRepository.findByIdOrElseThrow(id);

        findComment.setContents(contents);

        return new CommentResponseDto(findComment);
    }

    @Override
    public void delete(Long id) {
        Comment findComment = commentRepository.findByIdOrElseThrow(id);

        commentRepository.delete(findComment);
    }
}
