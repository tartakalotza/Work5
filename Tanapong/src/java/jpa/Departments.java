/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "departments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departments.findAll", query = "SELECT d FROM Departments d"),
    @NamedQuery(name = "Departments.findByDptid", query = "SELECT d FROM Departments d WHERE d.dptid = :dptid"),
    @NamedQuery(name = "Departments.findByDptname", query = "SELECT d FROM Departments d WHERE d.dptname = :dptname")})
public class Departments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Dpt_id")
    private Integer dptid;
    @Size(max = 40)
    @Column(name = "Dpt_name")
    private String dptname;
    @OneToMany(mappedBy = "dptid")
    private Collection<Employees> employeesCollection;

    public Departments() {
    }

    public Departments(Integer dptid) {
        this.dptid = dptid;
    }

    public Integer getDptid() {
        return dptid;
    }

    public void setDptid(Integer dptid) {
        this.dptid = dptid;
    }

    public String getDptname() {
        return dptname;
    }

    public void setDptname(String dptname) {
        this.dptname = dptname;
    }

    @XmlTransient
    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dptid != null ? dptid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departments)) {
            return false;
        }
        Departments other = (Departments) object;
        if ((this.dptid == null && other.dptid != null) || (this.dptid != null && !this.dptid.equals(other.dptid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Departments[ dptid=" + dptid + " ]";
    }
    
}
