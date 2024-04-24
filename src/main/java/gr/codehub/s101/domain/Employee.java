package gr.codehub.s101.domain;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String name;
    private int since;
    private double salary;
}
