/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.portalgame.statistics.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "cb_groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CbGroups.findAll", query = "SELECT c FROM CbGroups c"),
    @NamedQuery(name = "CbGroups.findByGroupname", query = "SELECT c FROM CbGroups c WHERE c.groupname = :groupname"),
    @NamedQuery(name = "CbGroups.findByUsername", query = "SELECT c FROM CbGroups c WHERE c.username = :username"),
    @NamedQuery(name = "CbGroups.findById", query = "SELECT c FROM CbGroups c WHERE c.id = :id")})
public class CbGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "groupname")
    private String groupname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    public CbGroups() {
    }

    public CbGroups(Integer id) {
        this.id = id;
    }

    public CbGroups(Integer id, String groupname, String username) {
        this.id = id;
        this.groupname = groupname;
        this.username = username;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CbGroups)) {
            return false;
        }
        CbGroups other = (CbGroups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.portalgame.statistics.entity.CbGroups[ id=" + id + " ]";
    }
    
}
