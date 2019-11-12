package com.HIT.software;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int recid;
    private String createtime;
    private String streetname;
    private String communityname;
    private String eventtypename;
    private String maintypename;
    private String subtypename;
    private String disposeunitname;
    private String eventsrcname;
    private String overtime;
    private String intimeto;
    private String intime;
    private String eventpropertyname;

    public int getRecid() {
        return recid;
    }

    public void setRecid(int recid) {
        this.recid = recid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getCommunityname() {
        return communityname;
    }

    public void setCommunityname(String communityname) {
        this.communityname = communityname;
    }

    public String getEventtypename() {
        return eventtypename;
    }

    public void setEventtypename(String eventtypename) {
        this.eventtypename = eventtypename;
    }

    public String getMaintypename() {
        return maintypename;
    }

    public void setMaintypename(String maintypename) {
        this.maintypename = maintypename;
    }

    public String getSubtypename() {
        return subtypename;
    }

    public void setSubtypename(String subtypename) {
        this.subtypename = subtypename;
    }

    public String getDisposeunitname() {
        return disposeunitname;
    }

    public void setDisposeunitname(String disposeunitname) {
        this.disposeunitname = disposeunitname;
    }

    public String getEventsrcname() {
        return eventsrcname;
    }

    public void setEventsrcname(String eventsrcname) {
        this.eventsrcname = eventsrcname;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    public String getIntimeto() {
        return intimeto;
    }

    public void setIntimeto(String intimeto) {
        this.intimeto = intimeto;
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
        this.intime = intime;
    }

    public String getEventpropertyname() {
        return eventpropertyname;
    }

    public void setEventpropertyname(String eventpropertyname) {
        this.eventpropertyname = eventpropertyname;
    }
}
