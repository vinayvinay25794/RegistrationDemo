package com.example.Hibernate.Service;

import java.util.List;
import java.util.Optional;

import com.example.Hibernate.Pojo.Candidate;

public interface CandidateServiceImpl {

	public void save(Candidate candidate);
	public Optional<Candidate> findById(long id);
	public void delete(Candidate candidate);
	List<Candidate> findAll();
	
}
