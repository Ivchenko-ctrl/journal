
package com.college;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;@Entity
@Table(name = "editorial_offices")
public class EditorialOfficeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String phone;
}