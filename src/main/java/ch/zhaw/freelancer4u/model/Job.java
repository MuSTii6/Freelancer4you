package ch.zhaw.freelancer4u.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Document("job")
public class Job {
    public Job(String description) {
    }
    @Id
    private String id;
    @NonNull
    private String description;
    @NonNull
    private Double earnings;
    
    private String freelancerId;

    @NonNull
    private JobType jobType;
    private JobState jobState = JobState.NEW;
    private String comment;


}