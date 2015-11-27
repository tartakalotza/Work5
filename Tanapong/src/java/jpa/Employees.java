/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dafunk
 */
@Entity
@Table(name = "employees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
    @NamedQuery(name = "Employees.findByEmpId", query = "SELECT e FROM Employees e WHERE e.empId = :empId"),
    @NamedQuery(name = "Employees.findByEmpName", query = "SELECT e FROM Employees e WHERE e.empName = :empName"),
    @NamedQuery(name = "Employees.findByBirthday", query = "SELECT e FROM Employees e WHERE e.birthday = :birthday"),
    @NamedQuery(name = "Employees.findByAddress", query = "SELECT e FROM Employees e WHERE e.address = :address"),
    @NamedQuery(name = "Employees.findByPhone", query = "SELECT e FROM Employees e WHERE e.phone = :phone"),
    @NamedQuery(name = "Employees.findByEmail", query = "SELECT e FROM Employees e WHERE e.email = :email"),
    @NamedQuery(name = "Employees.findBySex", query = "SELECT e FROM Employees e WHERE e.sex = :sex")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "emp_id")
    private Integer empId;
    @Size(max = 40)
    @Column(name = "emp_name")
    private String empName;
    @Size(max = 40)
    @Column(name = "Birthday")
    private String birthday;
    @Size(max = 40)
    @Column(name = "Address")
    private String address;
    @Column(name = "phone")
    private Integer phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "email")
    private String email;
    @Size(max = 10)
    @Column(name = "sex")
    private String sex;
    @JoinColumn(name = "Dpt_id", referencedColumnName = "Dpt_id")
    @ManyToOne
    private Departments dptid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empId")
    private Collection<Customer> customerCollection;
    @OneToMany(mappedBy = "empId")
    private Collection<Order1> order1Collection;
    @OneToMany(mappedBy = "empId")
    private Collection<Products> productsCollection;

    public Employees() {
    }

    public Employees(Integer empId) {
        this.empId = empId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Departments getDptid() {
        return dptid;
    }

    public void setDptid(Departments dptid) {
        this.dptid = dptid;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @XmlTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }

    @XmlTransient
    public Collection<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Collection<Products> productsCollection) {
        this.productsCollection = productsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Employees[ empId=" + empId + " ]";
    }
    
}
