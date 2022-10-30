package com.aeon.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.aeon.model.Karyawan;

@Repository
public interface KaryawanRepository extends PagingAndSortingRepository<Karyawan, Long> {

   Page<Karyawan> findByNamaContains(String nama, Pageable pageable);
   
}
