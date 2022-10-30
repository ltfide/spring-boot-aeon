package com.aeon.model;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "detail_karyawan")
public class DetailKaryawan {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @Column(length = 20, nullable = true)
   private String nik;

   @Column(length = 20, nullable = true)
   private String npwp;

   @OneToOne
   @MapsId
   @JoinColumn(name = "id_karyawan", nullable = false)
   @OnDelete(action = OnDeleteAction.CASCADE)
   private Karyawan karyawan;
   
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getNik() {
      return nik;
   }

   public void setNik(String nik) {
      this.nik = nik;
   }

   public String getNpwp() {
      return npwp;
   }

   public void setNpwp(String npwp) {
      this.npwp = npwp;
   }

   public Karyawan getKaryawan() {
      return karyawan;
   }

   public void setKaryawan(Karyawan karyawan) {
      this.karyawan = karyawan;
   }

}
