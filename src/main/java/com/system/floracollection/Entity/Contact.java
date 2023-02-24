package com.system.floracollection.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="contact")
public class Contact {
    @Id
    @SequenceGenerator(name = "gp_book_seq_gen", sequenceName = "gp_book_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "gp_book_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column (name = "email")
    private String email;
    @Column(name = "message")
    private String message;
}
