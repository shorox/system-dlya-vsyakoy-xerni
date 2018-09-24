package ru.rogaandkopyta.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "rk_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private Date startDate;
    private Date endDate;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Employee employee;

    public Order() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(name, order.name) &&
                Objects.equals(startDate, order.startDate) &&
                Objects.equals(endDate, order.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startDate, endDate);
    }
}
