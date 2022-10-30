package com.aeon.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeon.dto.RekeningData;
import com.aeon.dto.ResponseData;
import com.aeon.model.Rekening;
import com.aeon.services.RekeningService;

@RestController
@RequestMapping("/v1/rekening")
public class RekeningController {
   
   @Autowired
   private RekeningService rekeningService;

   @Autowired
   private ModelMapper modelMapper;

   @PostMapping
   public ResponseEntity<ResponseData<Rekening>> create(@Valid @RequestBody 
                                                         RekeningData rekeningData, 
                                                         Errors errors) {
      ResponseData<Rekening> responseData = new ResponseData<>();
      
      if (errors.hasErrors()) {
         for (ObjectError error : errors.getAllErrors()) {
            responseData.getMessages().add(error.getDefaultMessage());
         }
         responseData.setStatus(false);
         responseData.setPayload(null);
         ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
      }

      Rekening rekening = modelMapper.map(rekeningData, Rekening.class);
      responseData.setStatus(true);
      responseData.setPayload(rekeningService.save(rekening));
      return ResponseEntity.ok(responseData);
   }



}
