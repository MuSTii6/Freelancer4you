
package ch.zhaw.freelancer4u.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.freelancer4u.model.Job;
import ch.zhaw.freelancer4u.model.JobCreateDTO;
import ch.zhaw.freelancer4u.repository.JobRepository;

@RestController
public class JobController {
    @Autowired
    JobRepository jobRepository;

    @PostMapping("/job")
    public ResponseEntity<Job> createJob(
            @RequestBody JobCreateDTO jDTO) {
        Job jDAO = new Job(jDTO.getDescription()), jDTO.getEarnings()), jDTO.getJobType());
        Job j = JobRepository.save(jDAO);
        return new ResponseEntity<>(f, HttpStatus.CREATED);

    }

  

    @GetMapping("/job/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable String id) {
     Optional<Job> optJob = JobRepository.findById(id);
     if (optJob.isPresent()) {
     return new ResponseEntity<>(optJob.get(), HttpStatus.OK);
     } else {
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
    } 


    





}