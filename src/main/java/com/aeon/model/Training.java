package com.aeon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "training")
public class Training {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "nama_pengajar", length = 50, nullable = false)
   private String namaPengajar;

   @Column(length = 50)
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
