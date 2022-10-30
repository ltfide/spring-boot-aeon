package com.aeon.repository;

import javax.websocket.server.PathParam;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aeon.model.KaryawanTraining;

@Repository
public interface TrainingKaryawanRepository extends PagingAndSortingRepository<KaryawanTraining, Long> {
   
   @Query("SELECT kt FROM KaryawanTraining kt WHERE kt.karyawan.nama = :namaKaryawan OR kt.training.namaPengajar = :namaTraining")
   Page<KaryawanTraining> findNamaKaryawanByNama(@Param("namaKaryawan") String namaKaryawan,
                                                @Param("namaTraining") String namaTraining, Pageable pageable);

}
