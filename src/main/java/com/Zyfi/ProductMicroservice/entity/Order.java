package com.Zyfi.ProductMicroservice.entity;
import jakarta.persistence.*;

import java.util.Date;

@SuppressWarnings("LombokGetterMayBeUsed")
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;


    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "salesman_id", nullable = false)
    private Long salesmanId;

    @Column(name = "creation_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    @Column(name = "is_authorised", nullable = false)
    private Boolean isAuthorised = false;

    @Column(name = "authorised_person_id", nullable = true)
    private Long authorisedPersonId;

    @Column(name = "authorised_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date authorisedTime;

    @Column(name = "is_finished", nullable = false)
    private Boolean isFinished = false;

    @Column(name = "finished_person_id", nullable = false)
    private Long finishedPersonId;

    @Column(name = "finished_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishedTime;

    // Constructors, getters, setters, and other methods

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", number=" + number +
                ", price=" + price +
                ", clientId=" + clientId +
                ", salesmanId=" + salesmanId +
                ", creationTime=" + creationTime +
                ", isAuthorised=" + isAuthorised +
                ", authorisedPersonId=" + authorisedPersonId +
                ", authorisedTime=" + authorisedTime +
                ", isFinished=" + isFinished +
                ", finishedPersonId=" + finishedPersonId +
                ", finishedTime=" + finishedTime +
                '}';
    }

    public Order(Long productId, Integer number, Integer price, Long clientId, Long salesmanId) {
        this.productId = productId;
        this.number = number;
        this.price = price;
        this.clientId = clientId;
        this.salesmanId = salesmanId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(Long salesmanId) {
        this.salesmanId = salesmanId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Boolean getAuthorised() {
        return isAuthorised;
    }

    public void setAuthorised(Boolean authorised) {
        isAuthorised = authorised;
    }

    public Long getAuthorisedPersonId() {
        return authorisedPersonId;
    }

    public void setAuthorisedPersonId(Long authorisedPersonId) {
        this.authorisedPersonId = authorisedPersonId;
    }

    public Date getAuthorisedTime() {
        return authorisedTime;
    }

    public void setAuthorisedTime(Date authorisedTime) {
        this.authorisedTime = authorisedTime;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public Long getFinishedPersonId() {
        return finishedPersonId;
    }

    public void setFinishedPersonId(Long finishedPersonId) {
        this.finishedPersonId = finishedPersonId;
    }

    public Date getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
    }
// Constructors

    public Order() {
        // Default constructor
    }

    // Getters and setters

    // Other methods

}

