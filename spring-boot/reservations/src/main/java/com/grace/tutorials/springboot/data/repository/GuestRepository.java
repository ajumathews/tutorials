package com.grace.tutorials.springboot.data.repository;

import com.grace.tutorials.springboot.data.entity.Guest;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {
}
