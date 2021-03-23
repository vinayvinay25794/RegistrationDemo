package com.example.Hibernate.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.query.Procedure;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

import com.example.Hibernate.Pojo.Candidate;

//import antlr.collections.List;


public interface CandidateDao extends JpaRepository<Candidate, Long>{
	
	
	//@Procedure(procedureName = "find_candidate")
	@Query(value="CALL find_candidate();", nativeQuery = true)
	public List<Candidate> createStoredProcedureQuery();

	
	@Query(value="CALL delete_seleted_candidate(:p_id);", nativeQuery = true)
	public void createDeleteStoredProcedureQuery(@Param ("p_id") long id);
	
	@Query(value = "CALL UPDATE_candidate(:Id_in,:Position,:DOB,:EmailId,:FirstName,:LastName,:LinkedIn,:PHONE);",nativeQuery = true)
	public void updateCandidateProcedureQuery(@Param("Id_in") long id,@Param("Position") String Position,@Param("DOB") Date DOB, @Param("EmailId") String EmailId,
			@Param("FirstName") String FirstName, @Param("LastName") String LastName, @Param("LinkedIn") String LinkedIn,
			@Param("PHONE") String PHONE);
	
	@Query(value = "CALL SAVE_candidate(:Position,:DOB,:EmailId,:FirstName,:LastName,:LinkedIn,:PHONE);",nativeQuery = true)
	public void saveCandidateProcedureQuery(@Param("Position") String Position,@Param("DOB") Date date, @Param("EmailId") String EmailId,
			@Param("FirstName") String FirstName, @Param("LastName") String LastName, @Param("LinkedIn") String LinkedIn,
			@Param("PHONE") String PHONE);


	//public void saveCandidateProcedureQuery(String applyingForPosition, java.util.Date dateOfBirth, String emailId,
		//	String firstName, String lastName, String linkedIn, String phone);
	
}
