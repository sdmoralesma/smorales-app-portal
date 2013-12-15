package com.portalgame.statistics.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "statisticsofplayerxroom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatisticsOfPlayerXRoom.findAll", query = "SELECT s FROM StatisticsOfPlayerXRoom s"),
    @NamedQuery(name = "StatisticsOfPlayerXRoom.findById", query = "SELECT s FROM StatisticsOfPlayerXRoom s WHERE s.id = :id"),
    @NamedQuery(name = "StatisticsOfPlayerXRoom.findByPlayedTime", query = "SELECT s FROM StatisticsOfPlayerXRoom s WHERE s.playedTime = :playedTime"),
    @NamedQuery(name = "StatisticsOfPlayerXRoom.findByPortalsUsed", query = "SELECT s FROM StatisticsOfPlayerXRoom s WHERE s.portalsUsed = :portalsUsed")})
public class StatisticsOfPlayerXRoom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "playedTime")
    @Temporal(TemporalType.TIME)
    private Date playedTime;
    @Column(name = "portalsUsed")
    private Integer portalsUsed;
    @JoinColumn(name = "roomId", referencedColumnName = "id")
    @ManyToOne
    private Room roomId;
    @JoinColumn(name = "playerId", referencedColumnName = "id")
    @ManyToOne
    private Player playerId;

    public StatisticsOfPlayerXRoom() {
    }

    public StatisticsOfPlayerXRoom(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPlayedTime() {
        return playedTime;
    }

    public void setPlayedTime(Date playedTime) {
        this.playedTime = playedTime;
    }

    public Integer getPortalsUsed() {
        return portalsUsed;
    }

    public void setPortalsUsed(Integer portalsUsed) {
        this.portalsUsed = portalsUsed;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
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
        if (!(object instanceof StatisticsOfPlayerXRoom)) {
            return false;
        }
        StatisticsOfPlayerXRoom other = (StatisticsOfPlayerXRoom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.portalgame.statistics.entity.StatisticsOfPlayerXRoom[ id=" + id + " ]";
    }
    
}
