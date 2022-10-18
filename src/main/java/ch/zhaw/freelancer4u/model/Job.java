package ch.zhaw.freelancer4u.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Document("job")
public class Job extends Freelancer {
    @Id
    private String id;
    @NonNull
    private String description;
    @NonNull
    private Double earnings;
    private JobType jobType;
    private JobState jobState;
    @freelancerId
    private String freelancerId;

}