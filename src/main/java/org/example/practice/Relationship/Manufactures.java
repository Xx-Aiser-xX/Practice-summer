package org.example.practice.Relationship;

import jakarta.persistence.*;
import org.example.practice.Table.BaseEntity;
import org.example.practice.Table.Employee;
import org.example.practice.Table.ListOfProduct;

import java.sql.Timestamp;

@Entity
@Table(name = "изготавливает")
public class Manufactures extends BaseEntity {
    private int id;
    private Employee employee;
    private ListOfProduct listOfProduct;
    private Timestamp date;
    private Integer quantityOfGoodsProduced;
    private Timestamp expirationDate;


    public Manufactures(int id, Employee employee, ListOfProduct listOfProduct,
                        Timestamp date, int quantityOfGoodsProduced, Timestamp expirationDate){
        this.id = id;
        this.employee = employee;
        this.listOfProduct = listOfProduct;
        this.date = date;
        this.quantityOfGoodsProduced = quantityOfGoodsProduced;
        this.expirationDate = expirationDate;
    }

    public Manufactures() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_партии")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_сотрудника", referencedColumnName = "id_сотрудника")
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_товара", referencedColumnName = "id_товара")
    public ListOfProduct getListOfProduct() {
        return listOfProduct;
    }
    public void setListOfProduct(ListOfProduct listOfProduct) {
        this.listOfProduct = listOfProduct;
    }

    @Column(name = "дата")
    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Column(name = "кол_во_произведённого_товара")
    public Integer getQuantityOfGoodsProduced() {
        return quantityOfGoodsProduced;
    }
    public void setQuantityOfGoodsProduced(Integer quantityOfGoodsProduced) {
        this.quantityOfGoodsProduced = quantityOfGoodsProduced;
    }

    @Column(name = "срок_годности")
    public Timestamp getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }
}
