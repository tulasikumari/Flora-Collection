package com.system.floracollection.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {


        @Id
        @SequenceGenerator(name = "gp_product_seq_gen", sequenceName = "gp_product_seq_gen", allocationSize = 1)
        @GeneratedValue(generator = "gp_product_seq_gen", strategy = GenerationType.SEQUENCE)
        private Integer id;

//    @Column(name = "date")
//    private Date date;
        @Column
        private String date;



        @Column(nullable = false,name = "product_name")
        private String product_name;

        @Column(nullable = false,name = "product_price")
        private double product_price;

        @Column(nullable = false,name = "product_quantity")
        private double product_quantity;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_category",
//            referencedColumnName = "id",
//            foreignKey = @ForeignKey(name = "FK_categoryId"))
//    private Category product_category;

        @Column(name = "product_image",nullable = false)
        private String product_image;

        @Transient
        private String product_imageBase64;
    }

