package com.aeon.services;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aeon.model.Rekening;
import com.aeon.repository.RekeningRepository;

@Service
@Transactional
public class RekeningService {
   
   @Autowired
   private RekeningRepository rekeningRepository;

   public Iterable<Rekening> findAll() {
      return rekeningRepository.findAll();
   }

   public Rekening save(Rekening rekening) {
      return rekeningRepository.save(rekening);
   }



}
