package com.example.demo.job;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JobController {
	
	private JobService jobservice;
	
	public JobController(JobService jobservice) {
		
		this.jobservice = jobservice;
	}
	@GetMapping("/jobs")
	public ResponseEntity<List<Job>> findAll(){
		return new ResponseEntity<>(jobservice.findAll(),HttpStatus.OK);
		 
	}
	@PostMapping("/jobs")
	public ResponseEntity<String> createJob(  @RequestBody Job job) {
		jobservice.createJob(job);
		return new ResponseEntity<>("Job added sucessfully",HttpStatus.CREATED);
	}
	@GetMapping("/jobs/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Long id) {
		Job job=jobservice.getJobById(id);
		if(job!=null)
			return new ResponseEntity<>(job,HttpStatus.OK);
					
		return new  ResponseEntity<>(job,HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/jobs/{id}")
	public ResponseEntity<String>  deleteJob(@PathVariable Long id){
		boolean delete=jobservice.deleteJob(id);
		if(delete) {
			return new ResponseEntity<>("Succesfully Deleted",HttpStatus.OK);
		}
		return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/jobs/{id}")
	public ResponseEntity<String> updateJob(@PathVariable Long  id, 
											@RequestBody Job updatedJob){
		boolean updated=jobservice.updateJob(id,updatedJob);
		if(updated) {
			return new ResponseEntity<>("updated Succesfully", HttpStatus.OK);
		}
		return new  ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
		
	}

}
