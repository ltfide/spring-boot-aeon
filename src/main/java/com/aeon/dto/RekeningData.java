package com.aeon.dto;

import javax.validation.constraints.NotEmpty;

public class RekeningData {
   
   @NotEmpty(message = "Nama tidak boleh kosong")
   private String nama;

   @NotEmpty(message = "Jenis tidak boleh kosong")
   private String jenis;

   @NotEmpty(message = "Jenis tidak boleh kosong")
   private String nomor;

   private Integer karyawan_id;

   public String getNama() {
      return nama;
   }

   public void setNama(String nama) {
      this.nama = nama;
   }

   public String getJenis() {
      return jenis;
   }

   public void setJenis(String jenis) {
      this.jenis = jenis;
   }

   public String getNomor() {
      return nomor;
   }

   public void setNomor(String nomor) {
      this.nomor = nomor;
   }

   public Integer getKaryawan_id() {
      return karyawan_id;
   }

   public void setKaryawan_id(Integer karyawan_id) {
      this.karyawan_id = karyawan_id;
   }

}
