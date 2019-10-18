package org.javasoft.demoapi.payload.client.comment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@ToString
@Getter
@Setter
public class CommentRequest {

    @Max(value = 31)
    @Min(value = 1)
    private Long episodeId;

    @Length( max = 500)
    private String comment;
}
