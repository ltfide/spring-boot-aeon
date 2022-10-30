package com.aeon.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aeon.model.KaryawanTraining;
import com.aeon.repository.TrainingKaryawanRepository;

@Service
@Transactional
public class TrainingKaryawanService {
   
   @Autowired
   private TrainingKaryawanRepository trainingKaryawanRepository;

   public KaryawanTraining save(KaryawanTraining karyawanTraining) {
      return trainingKaryawanRepository.save(karyawanTraining);
   }

   public Iterable<KaryawanTraining> findAll() {
      return trainingKaryawanRepository.findAll();
   }

   public Iterable<KaryawanTraining> findByName(String namaKaryawan, String namaTraining, Pageable pageable) {
      return trainingKaryawanRepository.findNamaKaryawanByNama(namaKaryawan, namaTraining, pageable);
   }

}
