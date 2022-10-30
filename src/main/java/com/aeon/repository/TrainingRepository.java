package com.aeon.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.aeon.model.Training;

@Repository
public interface TrainingRepository extends PagingAndSortingRepository<Training, Long> {

   Page<Training> findByNamaPengajarContains(String namaPengajar, Pageable pageable); 

}
