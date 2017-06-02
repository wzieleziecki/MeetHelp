package info.wzielezicki.app.MeetHelp.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by wzielezi on 2017-05-23.
 */

@Document
public class Participant {

    private String idEvent;
    private String name;
    private String surname;
    private String email;
    private Integer attend;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date attendDataFrom;
    private Date attendDataTo;

    public Participant() {
    }

    public Participant(String idEvent, String name, String surname, String email, Integer attend, Date attendDataFrom, Date attendDataTo) {
        this.idEvent = idEvent;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.attend = attend;
        this.attendDataFrom = attendDataFrom;
        this.attendDataTo = attendDataTo;
    }

    public String getName() {
        return name;
    }

    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
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

    public Integer getAttend() {
        return attend;
    }

    public void setAttend(Integer attend) {
        this.attend = attend;
    }

    public Date getAttendDataFrom() {
        return attendDataFrom;
    }

    public void setAttendDataFrom(Date attendDataFrom) {
        this.attendDataFrom = attendDataFrom;
    }

    public Date getAttendDataTo() {
        return attendDataTo;
    }

    public void setAttendDataTo(Date attendDataTo) {
        this.attendDataTo = attendDataTo;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "idEvent='" + idEvent + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", attend=" + attend +
                ", attendDataFrom=" + attendDataFrom +
                ", attendDataTo=" + attendDataTo +
                '}';
    }
}