package org.javasoft.demoapi.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "EpisodeLog")
public class EpisodeLogEntity extends AbstractPersistable<Long>{

    private String episodeId;

    private String name ;

    @Temporal(TemporalType.TIMESTAMP)
    private Date airDate ;

    private String episodeCode;

    private int characterCount;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CommentLogEntity> commentLogEntityList;
}
