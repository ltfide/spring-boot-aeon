package com.aeon.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aeon.dto.ResponseData;
import com.aeon.dto.TrainingData;
import com.aeon.model.Training;
import com.aeon.repository.TrainingRepository;
import com.aeon.services.TrainingService;

@RestController
@RequestMapping("/v1/training")
public class TrainingController {
   
   @Autowired
   private TrainingService trainingService;

   @Autowired
   private ModelMapper modelMapper;

   @PostMapping
   public ResponseEntity<ResponseData<Training>> create(@Valid @RequestBody
                                                         TrainingData trainingData, Errors errors) {
      ResponseData<Training> responseData = new ResponseData<>();
      
      if (errors.hasErrors()) {
         for (ObjectError error : errors.getAllErrors()) {
            responseData.getMessages().add(error.getDefaultMessage());
         }
         responseData.setStatus(false);
         responseData.setPayload(null);
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
      }

      Training training = modelMapper.map(trainingData, Training.class);
      responseData.setStatus(true);
      responseData.setPayload(trainingService.save(training));
      return ResponseEntity.ok(responseData);
   }

   @PutMapping
   public ResponseEntity<ResponseData<Training>> update(@Valid @RequestBody
                                                         TrainingData trainingData, Errors errors) {
      ResponseData<Training> responseData = new ResponseData<>();
      
      if (errors.hasErrors()) {
         for (ObjectError error : errors.getAllErrors()) {
            responseData.getMessages().add(error.getDefaultMessage());
         }
         responseData.setStatus(false);
         responseData.setPayload(null);
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
      }

      Training training = modelMapper.map(trainingData, Training.class);
      responseData.setStatus(true);
      responseData.setPayload(trainingService.save(training));
      return ResponseEntity.ok(responseData);
   }

   @GetMapping("/list")
   public Iterable<Training> findByName(@RequestParam("nama") Optional<String> nama,
                                       @RequestParam("page") Optional<Integer> page) {
      Pageable pageable = PageRequest.of(page.orElse(0), 5);
      return trainingService.findByName(nama.orElse(""), pageable);
   }

   @GetMapping("/{id}")
   public Training getTrainingById(@PathVariable("id") Long id) {
      return trainingService.findById(id);
   } 

}
