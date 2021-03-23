package com.example.Hibernate.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Hibernate.Dao.CandidateDao;
import com.example.Hibernate.Pojo.Candidate;

@Service
public class CandidateService implements CandidateServiceImpl {


	@Autowired
	private CandidateDao dao;
	
	
	@Override
	public void save(Candidate candidate) {
		Candidate user = new Candidate(candidate.getFirstName(),
				candidate.getLastName(),
				candidate.getDateOfBirth(), 
				candidate.getApplyingForPosition(), 
				candidate.getEmailId(),
				candidate.getPhone(), 
				candidate.getLinkedIn(), 
				candidate.getAddress());
		//dao.save(user);
		//dao.saveCandidateProcedureQuery(0, null, null, null, null, null, null, null);
		dao.saveCandidateProcedureQuery(user.getApplyingForPosition(),
				user.getDateOfBirth(), 
				user.getEmailId(), 
				user.getFirstName(), 
				user.getLastName(), 
				user.getLinkedIn(),
				user.getPhone());
//		dao.saveCandidateProcedureQuery(user.getApplyingForPosition(),
//				user.getDateOfBirth(),
//				user.getFirstName(),
//				user.getLastName(),		
//				user.getEmailId(),
//				user.getLinkedIn(),
//				user.getPhone());
	}
	
	
	@Override
	public List<Candidate> findAll() {
	
		return dao.createStoredProcedureQuery();
		//return dao.findAll();
		
	}

	@Override
	public Optional<Candidate> findById(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}


	@Override
	public void delete(Candidate candidate) {
		long id = candidate.getId();
		dao.createDeleteStoredProcedureQuery(id);	
		}


	public void updateCandidateProcedureQuery(@Valid Candidate candidate) {
		// TODO Auto-generated method stub
		
	}
	
 
}
