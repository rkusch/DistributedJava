/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week10.namesapp10.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author ryan
 */
@Entity
public class Name {
    @Id
    @GeneratedValue
    private String id;
    @Column(name="firstname")
    private String first;
  @Column(name="lastname")
    private String last;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "addrid")
    private Address address;

    public Name(String id, String first, String last, Address address) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

   
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Name() {
    }
    
    
}
