package com.infy.movieRating.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="CUSTOMER_TBL")
public class CustomerTbl implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUST_ID", columnDefinition = "numeric")
    private Integer custId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE_NUMBER")
    private Long PhoneNumber;

    @OneToMany(mappedBy = "customerTbl")
    private List<RatingTbl> ratingTbl;

    public CustomerTbl() {}

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName;
    }

    public Long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public List<RatingTbl> getRatingTbl() {
        return ratingTbl;
    }

    public void setRatingTbl(List<RatingTbl> ratingTbl) {
        this.ratingTbl = ratingTbl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerTbl that = (CustomerTbl) o;
        return Objects.equals(custId, that.custId) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(PhoneNumber, that.PhoneNumber) &&
                Objects.equals(ratingTbl, that.ratingTbl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custId, firstName, lastName, PhoneNumber, ratingTbl);
    }
}
