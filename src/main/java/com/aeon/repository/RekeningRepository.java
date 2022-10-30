package com.aeon.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.aeon.model.Rekening;

@Repository
public interface RekeningRepository extends PagingAndSortingRepository<Rekening, Long> {

}
