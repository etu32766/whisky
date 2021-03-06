package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="commandline")
public class CommandLineEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="realprice")
    private Double realprice;
    @Column(name="quantity")
    private int quantity;
    @JoinColumn(name = "whiskyorder", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderEntity whiskyorder;
    @JoinColumn(name = "whisky", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private WhiskyEntity whisky;

    public void setRealprice(Double realprice) { this.realprice = realprice;}
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getQuantity() { return quantity; }
    public Double getRealprice() { return realprice; }
    public void setWhiskyorder(OrderEntity whiskyorder) { this.whiskyorder = whiskyorder; }
    public OrderEntity getWhiskyorder() { return whiskyorder; }
    public WhiskyEntity getWhisky() { return whisky; }
    public void setWhisky(WhiskyEntity whisky) { this.whisky = whisky; }
    public void setId(Integer id) { this.id = id; }
    public Integer getId() { return id; }
}
