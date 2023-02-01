package com.minotore.bookapp.models;


import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("magazine")
public class Magazine extends Book{

    private Date nextReleaseDate;
    @ElementCollection
    private List<String> keywords= new ArrayList<>();





}
