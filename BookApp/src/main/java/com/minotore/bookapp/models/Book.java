package com.minotore.bookapp.models;


import lombok.*;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@MappedSuperclass
@Entity
@Getter
@Setter
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="book_type")
@NoArgsConstructor

public abstract class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double price;
    private Long totalUnitsSold;
    private Date publicationDate;
    private Integer numberOfPages;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories= new ArrayList<>();

    @ManyToOne
    private Author author;
    @ManyToOne
    private Library library;

    public void addCategory(Category category){
        categories.add(category);
    }
}
