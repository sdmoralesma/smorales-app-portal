package com.portalgame.statistics.boundary;

import com.portalgame.statistics.entity.Player;
import com.portalgame.statistics.entity.Room;
import com.portalgame.statistics.entity.StatisticsGralXPlayer;
import com.portalgame.statistics.entity.StatisticsOfPlayerXRoom;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sergio.morales
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class Statistics {

    @PersistenceContext
    EntityManager em;

    public void createPlayer(String username) {
        Player p = new Player();
        p.setUsername(username);
        em.persist(p);
    }

    public void createRoom(String name) {
        Room r = new Room();
        r.setName(name);
        em.persist(r);
    }

    public void setPlayedTime(int idPlayer, int idRoom, long time) {
        Player p = em.find(Player.class, idPlayer);
        Room r = em.find(Room.class, idRoom);

        StatisticsOfPlayerXRoom stats = new StatisticsOfPlayerXRoom();
        stats.setPlayerId(p);
        stats.setRoomId(r);
        stats.setPlayedTime(new Date(time));
    }

    public void setPortalsUsed(int idPlayer, int idRoom, int numPortals) {
        Player p = em.find(Player.class, idPlayer);
        Room r = em.find(Room.class, idRoom);

        StatisticsOfPlayerXRoom stats = new StatisticsOfPlayerXRoom();
        stats.setPlayerId(p);
        stats.setRoomId(r);
        stats.setPortalsUsed(numPortals);
    }

    public void setRoomAchived(int idPlayer, int idRoom) {
        Player p = em.find(Player.class, idPlayer);
        Room r = em.find(Room.class, idRoom);

        StatisticsGralXPlayer stats = new StatisticsGralXPlayer();
        stats.setPlayerId(p);
        stats.setAchievedRoom(r);
    }

    public void setTimesPlayed(int idPlayer, int times) {
        Player p = em.find(Player.class, idPlayer);

        StatisticsGralXPlayer stats = new StatisticsGralXPlayer();
        stats.setPlayerId(p);
        stats.setTimesPlayed(times);
    }

    public List<Player> findAllPlayers() {
        return em.createNamedQuery("Player.findAll", Player.class).getResultList();
    }

    public List<Room> findAllRooms() {
        return em.createNamedQuery("Room.findAll", Room.class).getResultList();
    }

    public List<StatisticsGralXPlayer> findAllStatisticsGral() {
        return em.createNamedQuery("StatisticsGralXPlayer.findAll", StatisticsGralXPlayer.class).getResultList();
    }

    public List<StatisticsOfPlayerXRoom> findAllStatisticsOfPlayers() {
        return em.createNamedQuery("StatisticsOfPlayerXRoom.findAll", StatisticsOfPlayerXRoom.class).getResultList();
    }

    @Schedule(hour = "*/1", persistent = false)
    public void stayAwake() {

        try {
            URL url = new URL("http://portalgame.sdmoralesma.cloudbees.net/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();
            System.out.println("PAGE RESPOND > " + code);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
