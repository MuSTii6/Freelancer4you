package ch.zhaw.freelancer4u.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.freelancer4u.model.Job;

public interface JobRepository extends MongoRepository<Job,String>{
    Optional<Job> findByEarningsGreaterThan(Double earnings);
    List<Job> findByEarningsBetween(Double min, Double max);

}