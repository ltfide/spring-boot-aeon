package com.aeon.model;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "rekening")
public class Rekening {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(length = 50, nullable = false)
   private String nama;

   @Column(length = 50, nullable = false)
   private String jenis;
   
   @Column(length = 50, nullable = false)
   private String nomor;

   @ManyToOne
   @JoinColumn(name = "karyawan_id", nullable = false)
   @OnDelete(action = OnDeleteAction.CASCADE)
   private Karyawan karyawan;

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

   public Karyawan getKaryawan() {
      return karyawan;
   }

   public void setKaryawan(Karyawan karyawan) {
      this.karyawan = karyawan;
   }

}
