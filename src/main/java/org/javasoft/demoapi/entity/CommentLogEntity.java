package org.javasoft.demoapi.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity
@Table(name = "CommentLog")
public class CommentLogEntity extends AbstractPersistable<Long> {

    @NotBlank
    private String ipAddress ;

    @Column(length = 500)
    private String comment;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
}
