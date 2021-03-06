package com.app.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String departmentName;
    private String location;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Employee employee;

}
