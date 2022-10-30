package com.aeon.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "karyawan_training")
public class KaryawanTraining {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "tanggal_training", nullable = true)
   private Date tanggalTraining;
   
   @ManyToOne
   @JoinColumn(name = "karyawan_id", nullable = false)
   @OnDelete(action = OnDeleteAction.CASCADE)
   private Karyawan karyawan;

   @ManyToOne
   @JoinColumn(name = "training_id", nullable = false)
   @OnDelete(action = OnDeleteAction.CASCADE)
   private Training training;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Date getTanggalTraining() {
      return tanggalTraining;
   }

   public void setTanggalTraining(Date tanggalTraining) {
      this.tanggalTraining = tanggalTraining;
   }

   public Karyawan getKaryawan() {
      return karyawan;
   }

   public void setKaryawan(Karyawan karyawan) {
      this.karyawan = karyawan;
   }

   public Training getTraining() {
      return training;
   }

   public void setTraining(Training training) {
      this.training = training;
   }

}
