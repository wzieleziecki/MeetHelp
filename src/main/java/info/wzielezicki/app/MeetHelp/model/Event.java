package info.wzielezicki.app.MeetHelp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wzielezi on 2017-05-23.
 */

@Document
public class Event {

    @Id
    private String id;
    //:)
    private String optimalMeetingTimeFrom;
    private String optimalMeetingTimeto;
    private String coment;
    // TODO: 2017-06-03 domyślna wartość pola ma być "A"
    private String status;
    private String eventTitle;
    private Date eventDateTo;
    private Date eventDateFrom;
    private Integer minEventPartcipants;
    private Date eventDateConfirmTo;
    private String location;
    private Long minEventTimeInHours;
    private List<Participant> participantList = new ArrayList<>();

    public Event() {
    }

    public Event(String optimalMeetingTimeFrom, String optimalMeetingTimeto, String coment, String status, String eventTitle, Date eventDateTo, Date eventDateFrom, Integer minEventPartcipants, Date eventDateConfirmTo, String location, Long minEventTimeInHours, List<Participant> participantList) {
        this.optimalMeetingTimeFrom = optimalMeetingTimeFrom;
        this.optimalMeetingTimeto = optimalMeetingTimeto;
        this.coment = coment;
        this.status = status;
        this.eventTitle = eventTitle;
        this.eventDateTo = eventDateTo;
        this.eventDateFrom = eventDateFrom;
        this.minEventPartcipants = minEventPartcipants;
        this.eventDateConfirmTo = eventDateConfirmTo;
        this.location = location;
        this.minEventTimeInHours = minEventTimeInHours;
        this.participantList = participantList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOptimalMeetingTimeFrom() {
        return optimalMeetingTimeFrom;
    }

    public void setOptimalMeetingTimeFrom(String optimalMeetingTimeFrom) {
        this.optimalMeetingTimeFrom = optimalMeetingTimeFrom;
    }

    public String getOptimalMeetingTimeto() {
        return optimalMeetingTimeto;
    }

    public void setOptimalMeetingTimeto(String optimalMeetingTimeto) {
        this.optimalMeetingTimeto = optimalMeetingTimeto;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public Date getEventDateTo() {
        return eventDateTo;
    }

    public void setEventDateTo(Date eventDateTo) {
        this.eventDateTo = eventDateTo;
    }

    public Date getEventDateFrom() {
        return eventDateFrom;
    }

    public void setEventDateFrom(Date eventDateFrom) {
        this.eventDateFrom = eventDateFrom;
    }

    public Integer getMinEventPartcipants() {
        return minEventPartcipants;
    }

    public void setMinEventPartcipants(Integer minEventPartcipants) {
        this.minEventPartcipants = minEventPartcipants;
    }

    public Date getEventDateConfirmTo() {
        return eventDateConfirmTo;
    }

    public void setEventDateConfirmTo(Date eventDateConfirmTo) {
        this.eventDateConfirmTo = eventDateConfirmTo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getMinEventTimeInHours() {
        return minEventTimeInHours;
    }

    public void setMinEventTimeInHours(Long minEventTimeInHours) {
        this.minEventTimeInHours = minEventTimeInHours;
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }
}
