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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aeon.dto.KaryawanData;
import com.aeon.dto.ResponseData;
import com.aeon.model.Karyawan;
import com.aeon.services.KaryawanService;

@RestController
@RequestMapping("/v1/karyawan")
public class KaryawanController {
   
   @Autowired
   private KaryawanService karyawanService;

   @Autowired
   private ModelMapper modelMapper;

   @PostMapping
   public ResponseEntity<ResponseData<Karyawan>> create(@Valid @RequestBody KaryawanData karyawanData, Errors errors) {
      ResponseData<Karyawan> responseData = new ResponseData<>();

      if(errors.hasErrors()){
         for(ObjectError error : errors.getAllErrors()){
               responseData.getMessages().add(error.getDefaultMessage());
         }
         responseData.setStatus(false);
         responseData.setPayload(null);
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
      }
      
      Karyawan karyawan = modelMapper.map(karyawanData, Karyawan.class);
      responseData.setStatus(true);
      responseData.setPayload(karyawanService.save(karyawan));
      return ResponseEntity.ok(responseData);
   }

   @GetMapping("/list")
   public Iterable<Karyawan> findByName(@RequestParam("nama") Optional<String> nama,
                                       @RequestParam("page") Optional<Integer> page) {
      Pageable pageable = PageRequest.of(page.orElse(0), 5);
      return karyawanService.findByName(nama.orElse(""), pageable);
   }

   @GetMapping("/{id}")
   public Karyawan getKaryawanById(@PathVariable("id") Long id) {
      return karyawanService.findOne(id);
   }
   

}
