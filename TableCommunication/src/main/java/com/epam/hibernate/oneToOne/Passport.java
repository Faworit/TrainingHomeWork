package com.epam.hibernate.oneToOne;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "passport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "passport_id")
    private int passportId;
    @Column(name = "issue_date")
    private Timestamp issueDate;
    @Column(name = "valid_date")
    private Timestamp validDate;

    @OneToOne(mappedBy = "passport")
    private Person person;

    public Passport(Timestamp issueDate, Timestamp validDate) {
        this.issueDate = issueDate;
        this.validDate = validDate;
    }

    public Passport() {
    }

    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public Timestamp getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Timestamp issueDate) {
        this.issueDate = issueDate;
    }

    public Timestamp getValidDate() {
        return validDate;
    }

    public void setValidDate(Timestamp validDate) {
        this.validDate = validDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "passportId=" + passportId +
                ", issueDate=" + issueDate +
                ", validDate=" + validDate +

                '}';
    }
}
