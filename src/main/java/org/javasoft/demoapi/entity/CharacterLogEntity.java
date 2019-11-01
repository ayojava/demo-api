package org.javasoft.demoapi.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "characterlog")
public class CharacterLogEntity extends AbstractPersistable<Long> {

    private int characterId;

    private String name;

    private String status;

    private String species;

    private String type;

    private String gender;

    private int episodeList;
}
