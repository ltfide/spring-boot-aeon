package com.aeon.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aeon.model.Karyawan;
import com.aeon.repository.KaryawanRepository;

@Service
@Transactional
public class KaryawanService {
   
   @Autowired
   private KaryawanRepository karyawanRepository;

   public Karyawan save(Karyawan karyawan) {
      return karyawanRepository.save(karyawan);
   }

   public Iterable<Karyawan> findByName(String nama, Pageable pageable) {
      return karyawanRepository.findByNamaContains(nama, pageable);
   }

   public Karyawan findOne(Long id) {
      Optional<Karyawan> karyawan = karyawanRepository.findById(id);

      if (!karyawan.isPresent()) {
         return null;
      }

      return karyawan.get();
   }



}
