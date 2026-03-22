package com.main.repository;

import com.main.dto.BloodGroupStats;
import com.main.dto.CPatientInfo;
import com.main.dto.IPatientInfo;
import com.main.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p.id as id, p.name as name, p.email as email from Patient p")
    List<IPatientInfo> getAllPatientsInfo();

    @Query("select new com.main.dto.CPatientInfo(p.id, p.name) from Patient p")
    List<CPatientInfo> getAllPatientsInfoConcrete();

    @Query("select new com.main.dto.BloodGroupStats(p.bloodGroup, COUNT(p)) " + "from Patient p group by p.bloodGroup order by COUNT(p) DESC")
    List<BloodGroupStats> getBloodGroupStats();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p set p.name = :name where p.id = :id")
    int updatePatientNameWithId(@Param("name") String name, @Param("id") Long id);

    @Query("select p from Patient p LEFT JOIN FETCH p.appointments")
    List<Patient> getAllPatientsWithAppointments();
}