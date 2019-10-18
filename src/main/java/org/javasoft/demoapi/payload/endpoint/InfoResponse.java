package org.javasoft.demoapi.payload.endpoint;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class InfoResponse {

    private int count;

    private int pages;

    private String next;

    private String prev;
}
