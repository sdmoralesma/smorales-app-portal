package com.portalgame.statistics.boundary.rest;

import com.portalgame.statistics.boundary.Statistics;
import com.portalgame.statistics.entity.Player;
import com.portalgame.statistics.entity.Room;
import com.portalgame.statistics.entity.StatisticsGralXPlayer;
import com.portalgame.statistics.entity.StatisticsOfPlayerXRoom;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sergio
 */
@Path("/statistics")
public class StatisticsResource {

    @EJB
    Statistics statistics;

    @GET
    @Path("/createPlayer")
    public Response createPlayer(
            @QueryParam(value = "username") String username) {

        statistics.createPlayer(username);
        String output = "Player created!, username= " + username;
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/createRoom")
    public Response createRoom(
            @QueryParam("name") String name) {

        statistics.createRoom(name);
        String output = "Room created!, name= " + name;
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("setPlayedTime")
    public Response setPlayedTime(
            @QueryParam("idPlayer") int idPlayer,
            @QueryParam("idRoom") int idRoom,
            @QueryParam("time") long time) {

        statistics.setPlayedTime(idPlayer, idRoom, time);
        String output = "SetPlayedTime was OK";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("setPortalsUsed")
    public Response setPortalsUsed(
            @QueryParam("idPlayer") int idPlayer,
            @QueryParam("idRoom") int idRoom,
            @QueryParam("numPortals") int numPortals) {

        statistics.setPortalsUsed(idPlayer, idRoom, numPortals);
        String output = "SetPortalsUsed was OK";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("setRoomAchived")
    public Response setRoomAchieved(
            @QueryParam("idPlayer") int idPlayer,
            @QueryParam("idRoom") int idRoom) {

        statistics.setRoomAchived(idPlayer, idRoom);
        String output = "SetRoomAchieved was OK";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("setTimesPlayed")
    public Response setTimesPlayed(
            @QueryParam("idPlayer") int idPlayer,
            @QueryParam("times") int times) {

        statistics.setTimesPlayed(idPlayer, times);
        String output = "SetTimesPlayed was OK";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/hi")
    public Response hi() {
        String output = "The StatisticsResource is working!";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/findAllPlayers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> findAllPlayers() {
        return statistics.findAllPlayers();
    }

    @GET
    @Path("/findAllRooms")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> findAllRooms() {
        return statistics.findAllRooms();
    }

    @GET
    @Path("/findAllStatsGral")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StatisticsGralXPlayer> findAllStatisticsGral() {
        return statistics.findAllStatisticsGral();
    }

    @GET
    @Path("/findAllStatsOfPlayers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StatisticsOfPlayerXRoom> findAllStatisticsOfPlayers() {
        return statistics.findAllStatisticsOfPlayers();
    }
}
