/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dafunk
 */
@Entity
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findByOrdername", query = "SELECT o FROM Order1 o WHERE o.ordername = :ordername"),
    @NamedQuery(name = "Order1.findByOrderid", query = "SELECT o FROM Order1 o WHERE o.orderid = :orderid")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 40)
    @Column(name = "Order_name")
    private String ordername;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Order_id")
    private Integer orderid;
    @JoinColumn(name = "cus_id", referencedColumnName = "cus_id")
    @ManyToOne
    private Customer cusId;
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    @ManyToOne
    private Employees empId;

    public Order1() {
    }

    public Order1(Integer orderid) {
        this.orderid = orderid;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Customer getCusId() {
        return cusId;
    }

    public void setCusId(Customer cusId) {
        this.cusId = cusId;
    }

    public Employees getEmpId() {
        return empId;
    }

    public void setEmpId(Employees empId) {
        this.empId = empId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Order1[ orderid=" + orderid + " ]";
    }
    
}
