package com.example.demo.job.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.job.Job;
import com.example.demo.job.JobService;

@Service
public class JobServiceImplementation implements JobService {
	private List<Job> jobs=new ArrayList<>();
	private Long longId=1L;
	
	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobs;
	}

	@Override
	public void createJob( @RequestBody Job job) {
		// TODO Auto-generated method stub
		job.setId(longId++);
		jobs.add(job);
		
	}

	@Override
	public Job getJobById(Long id) {
		// TODO Auto-generated method stub
		for( Job job:jobs) {
			if(job.getId()==id) {
				return job;
			}
		}
		return null;
	}

	@Override
	public boolean deleteJob(Long id) {
		// TODO Auto-generated method stub
		
		Iterator<Job> itr=jobs.iterator();
		while(itr.hasNext()) {
			Job job=itr.next();
			if(job.getId().equals(id)) {
				itr.remove();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateJob(Long id,Job updateJob) {
		// TODO Auto-generated method stub
		for(Job job:jobs) {
			if(job.getId().equals(id)) {
				job.setTitle(updateJob.getTitle());
				job.setDescription(updateJob.getDescription());
				job.setMinSalary(updateJob.getMinSalary());
				job.setMaxSalary(updateJob.getMaxSalary());
				job.setLocation(updateJob.getLocation());
				
				return true;
			}
		}
		return false;
	}

	

}
  