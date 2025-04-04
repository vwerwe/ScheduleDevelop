package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.responseDto.PageResponseDto;
import com.example.scheduledevelop.dto.responseDto.ScheduleResponseDto;
import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.ScheduleRepository;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Override
    public ScheduleResponseDto save(String username, String title, String contents) {

        User findUser = userRepository.findUserByUsernameOrElseThrow(username);

        Schedule schedule = new Schedule(title, contents);

        schedule.setUser(findUser);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule);
    }

    @Override
    public Page<ScheduleResponseDto> findAll(Pageable pageable) {

        Page<Schedule> schedulePage = scheduleRepository.findAll(pageable);

        return schedulePage.map(ScheduleResponseDto::new);
    }

    @Override
    public ScheduleResponseDto findById(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        return new ScheduleResponseDto(findSchedule);
    }

    @Transactional
    @Override
    public ScheduleResponseDto updateSchedule(Long id, String title, String contents) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        findSchedule.updateSchedule(title, contents);

        return new ScheduleResponseDto(findSchedule);
    }

    @Override
    public void delete(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);

    }

    @Override
    public Page<PageResponseDto> findPageBySchedule(Pageable pageable) {

        return scheduleRepository.findPageBySchedule(pageable);
    }
}
