package org.example.practice.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    private Client client;
    private ListOfProduct listOfProduct;
    private Date date;
    private int theQuantityOfTheProduct;


    public Order(Client client, ListOfProduct listOfProduct,
                 Date date, int theQuantityOfTheProduct){
        this.client = client;
        this.listOfProduct = listOfProduct;
        this.date = date;
        this.theQuantityOfTheProduct = theQuantityOfTheProduct;
    }

    protected Order() {

    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    public ListOfProduct getListOfProduct() {
        return listOfProduct;
    }
    public void setListOfProduct(ListOfProduct listOfProduct) {
        this.listOfProduct = listOfProduct;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "number_of_items")
    public int getTheQuantityOfTheProduct() {
        return theQuantityOfTheProduct;
    }
    public void setTheQuantityOfTheProduct(int theQuantityOfTheProduct) {
        this.theQuantityOfTheProduct = theQuantityOfTheProduct;
    }
}
