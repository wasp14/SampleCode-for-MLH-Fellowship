package com.sat_results.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sat_results.Models.satResults;

@Repository
public interface resultsRepo extends JpaRepository<satResults, String> {

	public List<satResults> findAllByOrderBySatscoreDesc();
	
	
}
