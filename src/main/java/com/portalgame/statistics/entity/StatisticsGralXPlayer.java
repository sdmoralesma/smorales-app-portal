package com.portalgame.statistics.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "statisticsgralxplayer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatisticsGralXPlayer.findAll", query = "SELECT s FROM StatisticsGralXPlayer s"),
    @NamedQuery(name = "StatisticsGralXPlayer.findById", query = "SELECT s FROM StatisticsGralXPlayer s WHERE s.id = :id"),
    @NamedQuery(name = "StatisticsGralXPlayer.findByTimesPlayed", query = "SELECT s FROM StatisticsGralXPlayer s WHERE s.timesPlayed = :timesPlayed")})
public class StatisticsGralXPlayer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "timesPlayed")
    private Integer timesPlayed;
    @JoinColumn(name = "achievedRoom", referencedColumnName = "id")
    @ManyToOne
    private Room achievedRoom;
    @JoinColumn(name = "playerId", referencedColumnName = "id")
    @ManyToOne
    private Player playerId;

    public StatisticsGralXPlayer() {
    }

    public StatisticsGralXPlayer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(Integer timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

    public Room getAchievedRoom() {
        return achievedRoom;
    }

    public void setAchievedRoom(Room achievedRoom) {
        this.achievedRoom = achievedRoom;
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
        if (!(object instanceof StatisticsGralXPlayer)) {
            return false;
        }
        StatisticsGralXPlayer other = (StatisticsGralXPlayer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.portalgame.statistics.entity.StatisticsGralXPlayer[ id=" + id + " ]";
    }
    
}
