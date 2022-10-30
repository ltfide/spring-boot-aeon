package com.aeon.dto;

import javax.validation.constraints.NotEmpty;

public class TrainingData {

   private Long id;
   
   @NotEmpty(message = "Nama pengajar tidak boleh kosong")
   private String namaPengajar;

   @NotEmpty(message = "Tema tidak boleh kosong")
   private String tema;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getNamaPengajar() {
      return namaPengajar;
   }

   public void setNamaPengajar(String namaPengajar) {
      this.namaPengajar = namaPengajar;
   }

   public String getTema() {
      return tema;
   }

   public void setTema(String tema) {
      this.tema = tema;
   }

}
