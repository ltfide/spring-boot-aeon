package com.aeon.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aeon.model.Training;
import com.aeon.repository.TrainingRepository;

@Service
@Transactional
public class TrainingService {

   @Autowired
   private TrainingRepository trainingRepository;

   public Training save(Training training) {
      return trainingRepository.save(training);
   }

   public Training findById(Long id) {
      Optional<Training> training = trainingRepository.findById(id);

      if (!training.isPresent()) {
         return null;
      }
      return training.get();
   }

   public Iterable<Training> findByName(String nama, Pageable pageable) {
      return trainingRepository.findByNamaPengajarContains(nama, pageable);
   }

}
