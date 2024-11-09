package org.bada.hw2.model;

import java.util.List;
import java.util.Objects;

public class Customer {

    private final int customer_id;
    private int storeId;
    private String fristName;
    private String lastName;
    private String email;
    private int addressId;
    private int active;
    private String createDate;
    private String lastUpdate;

    private List<Customer> customers = null;

    public Customer(int customer_id, int storeId, String fristName, String lastName, String email, int addressId, int active, String createDate, String lastUpdate) {
        this.customer_id = customer_id;
        this.storeId = storeId;
        this.fristName = fristName;
        this.lastName = lastName;
        this.email = email;
        this.addressId = addressId;
        this.active = active;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
    }

    public Customer(int customerId, String fristName, String lastName) {
        customer_id = customerId;
        this.fristName = fristName;
        this.lastName = lastName;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customer_id == customer.customer_id && storeId == customer.storeId && addressId == customer.addressId && active == customer.active && Objects.equals(fristName, customer.fristName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(createDate, customer.createDate) && Objects.equals(lastUpdate, customer.lastUpdate);
    }



    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", storeId=" + storeId +
                ", fristName='" + fristName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", addressId=" + addressId +
                ", active=" + active +
                ", createDate='" + createDate + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                '}';
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
