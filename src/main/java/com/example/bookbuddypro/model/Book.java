package com.example.bookbuddypro.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Year;
import java.util.Set;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String title;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;


    private String coverImagePath;

    private String rating;

    private String description;

    private LocalDate dateAdded;
    @PrePersist
    protected void onCreate() {
        this.dateAdded = LocalDate.now();
    }

    private Year datePublished;

    @ManyToMany
    @JoinTable(
            name = "book_folder",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "folder_id")
    )
    private Set<Folder> folders;

    private String format;

    @ElementCollection
    @CollectionTable(name = "book_tag", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "tag")
    private Set<String> tags;

    @ManyToMany
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

}
