package org.example.practice.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

    private BranchOfTheOrganization branchOfTheOrganization;
    private Human human;
    private Date dataOfHiring;
    private double wages;
    private String post;
    private Date birthday;
    private Set<Manufactures> manufactures;


    public Employee(BranchOfTheOrganization branchOfTheOrganization, Human human,
                    Date dataOfHiring, double wages, String post, Date birthday){

        this.branchOfTheOrganization = branchOfTheOrganization;
        this.human = human;
        this.dataOfHiring = dataOfHiring;
        this.wages = wages;
        this.post = post;
        this.birthday = birthday;
    }

    protected Employee() {

    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "branch", referencedColumnName = "id")
    public BranchOfTheOrganization getBranchOfTheOrganization() {
        return branchOfTheOrganization;
    }
    public void setBranchOfTheOrganization(BranchOfTheOrganization branchOfTheOrganization) {
        this.branchOfTheOrganization = branchOfTheOrganization;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_human", referencedColumnName = "id")
    public Human getHuman() {
        return human;
    }
    public void setHuman(Human human) {
        this.human = human;
    }


    @Column(name = "date_of_hiring")
    @Temporal(TemporalType.DATE)
    public Date getDataOfHiring() { return dataOfHiring;}
    public void setDataOfHiring(Date dataOfHiring) {
        this.dataOfHiring = dataOfHiring;
    }

    @Column(name = "salary")
    public double getWages() { return wages;}
    public void setWages(double wages) { this.wages = wages;}

    @Column(name = "post")
    public String getPost() { return post;}
    public void setPost(String post) { this.post = post;}

    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    public Date getBirthday() { return birthday;}
    public void setBirthday(Date birthday) { this.birthday = birthday;}

    @OneToMany(mappedBy = "employee", targetEntity = Manufactures.class)
    public Set<Manufactures> getManufactures() {
        return manufactures;
    }
    public void setManufactures(Set<Manufactures> manufactures) {
        this.manufactures = manufactures;
    }
}
