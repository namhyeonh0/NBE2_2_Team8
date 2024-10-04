package edu.example.learner.courseabout.courseqna.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name="course_answer")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class CourseAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    private String answerContent;

    @CreatedDate
    private LocalDateTime answerCreateDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "inquiry_id")
    @JsonBackReference
    private CourseInquiry courseInquiry;

    public void changeAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }
}
