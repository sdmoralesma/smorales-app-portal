package com.portalgame.statistics.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "player")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
    @NamedQuery(name = "Player.findById", query = "SELECT p FROM Player p WHERE p.id = :id"),
    @NamedQuery(name = "Player.findByUsername", query = "SELECT p FROM Player p WHERE p.username = :username")})
public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "username")
    private String username;
    @OneToMany(mappedBy = "playerId")
    private List<StatisticsGralXPlayer> statisticsGralXPlayerList;
    @OneToMany(mappedBy = "playerId")
    private List<StatisticsOfPlayerXRoom> statisticsOfPlayerXRoomList;

    public Player() {
    }

    public Player(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlTransient
    public List<StatisticsGralXPlayer> getStatisticsGralXPlayerList() {
        return statisticsGralXPlayerList;
    }

    public void setStatisticsGralXPlayerList(List<StatisticsGralXPlayer> statisticsGralXPlayerList) {
        this.statisticsGralXPlayerList = statisticsGralXPlayerList;
    }

    @XmlTransient
    public List<StatisticsOfPlayerXRoom> getStatisticsOfPlayerXRoomList() {
        return statisticsOfPlayerXRoomList;
    }

    public void setStatisticsOfPlayerXRoomList(List<StatisticsOfPlayerXRoom> statisticsOfPlayerXRoomList) {
        this.statisticsOfPlayerXRoomList = statisticsOfPlayerXRoomList;
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
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.portalgame.statistics.entity.Player[ id=" + id + " ]";
    }
    
}
