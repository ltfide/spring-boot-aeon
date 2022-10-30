package com.aeon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "karyawan")
public class Karyawan {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(length = 50, nullable = false)
   private String nama;

   @Column(length = 200)
   private String alamat;

   @Column(length = 50, nullable = false)
   private String status;

   @Column(name = "dob")
   private Date dateOfBirth;

   @Column(name = "jk", length = 50, nullable = false)
   private String jaminanKematian;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

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
