package com.aeon.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class KaryawanData {

   @NotEmpty(message = "Nama tidak boleh kosong")
   private String nama;

   private String alamat;

   @NotEmpty(message = "Status tidak boleh kosong")
   private String status;

   private Date dateOfBirth;

   @NotEmpty(message = "Jaminan kematian tidak boleh kosong")
   private String jaminanKematian;

   public String getNama() {
      return nama;
   }

   public void setNama(String nama) {
      this.nama = nama;
   }

   public String getAlamat() {
      return alamat;
   }

   public void setAlamat(String alamat) {
      this.alamat = alamat;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public Date getDateOfBirth() {
      return dateOfBirth;
   }

   public void setDateOfBirth(Date dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
   }

   public String getJaminanKematian() {
      return jaminanKematian;
   }

   public void setJaminanKematian(String jaminanKematian) {
      this.jaminanKematian = jaminanKematian;
   }

}
