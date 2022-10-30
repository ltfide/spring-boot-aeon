package com.aeon.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aeon.dto.ResponseData;
import com.aeon.model.KaryawanTraining;
import com.aeon.services.TrainingKaryawanService;

@RestController
@RequestMapping("/v1/training-karyawan")
public class TrainingKaryawanController {
   
   @Autowired
   private TrainingKaryawanService trainingKaryawanService;

   @PostMapping
   public ResponseEntity<ResponseData<KaryawanTraining>> create(@Valid @RequestBody
                                                               KaryawanTraining karyawanTraining, Errors errors) {
      ResponseData<KaryawanTraining> responseData = new ResponseData<>();

      if (errors.hasErrors()) {
         for (ObjectError error : errors.getAllErrors()) {
            responseData.getMessages().add(error.getDefaultMessage());
         }
         responseData.setStatus(false);
         responseData.setPayload(null);
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
      }

      responseData.setStatus(true);
      responseData.setPayload(trainingKaryawanService.save(karyawanTraining));
      return ResponseEntity.ok(responseData);
   }

   @GetMapping
   public Iterable<KaryawanTraining> findAll() {
      return trainingKaryawanService.findAll();
   }

   @GetMapping("/list")
   public Iterable<KaryawanTraining> findByName(@RequestParam("namaKaryawan") Optional<String> namaKaryawan,
                                             @RequestParam("namaTraining") Optional<String> namaTraining,
                                             @RequestParam("page") Optional<Integer> page) {
      Pageable pageable = PageRequest.of(page.orElse(0), 5);
      return trainingKaryawanService.findByName(namaKaryawan.orElse(""), namaTraining.orElse(""), pageable);
   }
   

}
