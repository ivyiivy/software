package com.HIT.software;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Integer> {
    List<Event> findByCreatetime(String CREATE_TIME);
}
