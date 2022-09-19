package com.baizhi.entity;


import lombok.Data;

import java.util.Date;

@Data
public class Emp {
    private String id;
    private String name;
    private Double salary;
    private Integer age;
    private Date bir;

}
