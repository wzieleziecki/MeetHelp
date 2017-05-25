package info.wzielezicki.app.MeetHelp.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by wzielezi on 2017-05-23.
 */

@Document
public class Participant {

    private String idEvent;
    private String name;
    private String surname;
    private String email;
    private String attend;
    private String attendDataFrom;
    private String attendDataTo;

    public Participant() {
    }

    public Participant(String idEvent, String name, String surname, String email, String attend, String attendDataFrom, String attendDataTo) {
        this.idEvent = idEvent;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.attend = attend;
        this.attendDataFrom = attendDataFrom;
        this.attendDataTo = attendDataTo;
    }

    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAttend() {
        return attend;
    }

    public void setAttend(String attend) {
        this.attend = attend;
    }

    public String getAttendDataFrom() {
        return attendDataFrom;
    }

    public void setAttendDataFrom(String attendDataFrom) {
        this.attendDataFrom = attendDataFrom;
    }

    public String getAttendDataTo() {
        return attendDataTo;
    }

    public void setAttendDataTo(String attendDataTo) {
        this.attendDataTo = attendDataTo;
    }
}
