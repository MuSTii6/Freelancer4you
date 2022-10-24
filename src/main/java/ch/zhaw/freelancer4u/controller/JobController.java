
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.freelancer4u.model.Job;
import ch.zhaw.freelancer4u.model.JobCreateDTO;
import ch.zhaw.freelancer4u.repository.JobRepository;

@RestController
@RequestMapping("/api/job")
public class JobController {
    @Autowired
    JobRepository jobRepository;

    @PostMapping("/api/job")
    public ResponseEntity<Job> createJob(
            @RequestBody JobCreateDTO fDTO) {
        Job fDAO = new Job(fDTO.getDescription(),fDTO.getEarnings(),fDTO.getJobType());
        Job f = jobRepository.save(fDAO);
        return new ResponseEntity<>(f, HttpStatus.CREATED);

    }

  
    @GetMapping("/api/job")
    public ResponseEntity<List<Job>> getAllJob() {
        List<Job> allFree = jobRepository.findAll();
        return new ResponseEntity<>(allFree, HttpStatus.OK);
    }
    


    @GetMapping("/api/job/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable String id) {
     Optional<Job> optJob = jobRepository.findById(id);
     if (optJob.isPresent()) {
     return new ResponseEntity<>(optJob.get(), HttpStatus.OK);
     } else {
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
    } 

    




}