package info.wzielezicki.app.MeetHelp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by wzielezi on 2017-05-23.
 */

@Document
public class Event {

    @Id
    private String id;
    private String eventTitle;
    private String eventDateFrom;
    private String eventDateTo;
    private String minEventPartcipants; //waga: minimum uczestników
    private String eventDateConfirmTo;
    private String location;
    private String minEventTime;//waga: minimum czasu potrzebnego na spotkanie

    // TODO: 2017-05-24 jak zaprogramować w przyszłości inne wagi dla spotkań?


    public Event() {
    }

    public Event(String eventTitle, String eventDateFrom, String eventDateTo, String minEventPartcipants, String eventDateConfirmTo, String location, String minEventTime) {
        this.eventTitle = eventTitle;
        this.eventDateFrom = eventDateFrom;
        this.eventDateTo = eventDateTo;
        this.minEventPartcipants = minEventPartcipants;
        this.eventDateConfirmTo = eventDateConfirmTo;
        this.location = location;
        this.minEventTime = minEventTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDateFrom() {
        return eventDateFrom;
    }

    public void setEventDateFrom(String eventDateFrom) {
        this.eventDateFrom = eventDateFrom;
    }

    public String getEventDateTo() {
        return eventDateTo;
    }

    public void setEventDateTo(String eventDateTo) {
        this.eventDateTo = eventDateTo;
    }

    public String getMinEventPartcipants() {
        return minEventPartcipants;
    }

    public void setMinEventPartcipants(String minEventPartcipants) {
        this.minEventPartcipants = minEventPartcipants;
    }

    public String getEventDateConfirmTo() {
        return eventDateConfirmTo;
    }

    public void setEventDateConfirmTo(String eventDateConfirmTo) {
        this.eventDateConfirmTo = eventDateConfirmTo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMinEventTime() {
        return minEventTime;
    }

    public void setMinEventTime(String minEventTime) {
        this.minEventTime = minEventTime;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", eventTitle='" + eventTitle + '\'' +
                ", eventDateFrom='" + eventDateFrom + '\'' +
                ", eventDateTo='" + eventDateTo + '\'' +
                ", minEventPartcipants='" + minEventPartcipants + '\'' +
                ", eventDateConfirmTo='" + eventDateConfirmTo + '\'' +
                ", location='" + location + '\'' +
                ", minEventTime='" + minEventTime + '\'' +
                '}';
    }
}
