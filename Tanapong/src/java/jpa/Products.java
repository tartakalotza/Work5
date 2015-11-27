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
@Table(name = "products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProid", query = "SELECT p FROM Products p WHERE p.proid = :proid"),
    @NamedQuery(name = "Products.findByProname", query = "SELECT p FROM Products p WHERE p.proname = :proname"),
    @NamedQuery(name = "Products.findByPrice", query = "SELECT p FROM Products p WHERE p.price = :price")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Pro_id")
    private Integer proid;
    @Size(max = 40)
    @Column(name = "Pro_name")
    private String proname;
    @Size(max = 40)
    @Column(name = "Price")
    private String price;
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    @ManyToOne
    private Employees empId;

    public Products() {
    }

    public Products(Integer proid) {
        this.proid = proid;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
        hash += (proid != null ? proid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.proid == null && other.proid != null) || (this.proid != null && !this.proid.equals(other.proid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Products[ proid=" + proid + " ]";
    }
    
}
