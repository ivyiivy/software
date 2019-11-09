package com.HIT.software;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int REC_ID;
    private String createtime;
    private String streetname;
    private String COMMUNITY_NAME;
    private String EVENT_TYPE_NAME;
    private String MAIN_TYPE_NAME;
    private String SUB_TYPE_NAME;
    private String DISPOSE_UNIT_NAME;
    private String EVENT_SRC_NAME;
    private String OVERTIME_ARCHIVE_NUM;
    private String INTIME_TO_ARCHIVE_NUM;
    private String INTIME_ARCHIVE_NUM;
    private String EVENT_PROPERTY_NAME;

    public int getREC_ID() {
        return REC_ID;
    }

    public void setREC_ID(int REC_ID) {
        this.REC_ID = REC_ID;
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

    public String getCOMMUNITY_NAME() {
        return COMMUNITY_NAME;
    }

    public void setCOMMUNITY_NAME(String COMMUNITY_NAME) {
        this.COMMUNITY_NAME = COMMUNITY_NAME;
    }

    public String getEVENT_TYPE_NAME() {
        return EVENT_TYPE_NAME;
    }

    public void setEVENT_TYPE_NAME(String EVENT_TYPE_NAME) {
        this.EVENT_TYPE_NAME = EVENT_TYPE_NAME;
    }

    public String getMAIN_TYPE_NAME() {
        return MAIN_TYPE_NAME;
    }

    public void setMAIN_TYPE_NAME(String MAIN_TYPE_NAME) {
        this.MAIN_TYPE_NAME = MAIN_TYPE_NAME;
    }

    public String getSUB_TYPE_NAME() {
        return SUB_TYPE_NAME;
    }

    public void setSUB_TYPE_NAME(String SUB_TYPE_NAME) {
        this.SUB_TYPE_NAME = SUB_TYPE_NAME;
    }

    public String getDISPOSE_UNIT_NAME() {
        return DISPOSE_UNIT_NAME;
    }

    public void setDISPOSE_UNIT_NAME(String DISPOSE_UNIT_NAME) {
        this.DISPOSE_UNIT_NAME = DISPOSE_UNIT_NAME;
    }

    public String getEVENT_SRC_NAME() {
        return EVENT_SRC_NAME;
    }

    public void setEVENT_SRC_NAME(String EVENT_SRC_NAME) {
        this.EVENT_SRC_NAME = EVENT_SRC_NAME;
    }

    public String getOVERTIME_ARCHIVE_NUM() {
        return OVERTIME_ARCHIVE_NUM;
    }

    public void setOVERTIME_ARCHIVE_NUM(String OVERTIME_ARCHIVE_NUM) {
        this.OVERTIME_ARCHIVE_NUM = OVERTIME_ARCHIVE_NUM;
    }

    public String getINTIME_TO_ARCHIVE_NUM() {
        return INTIME_TO_ARCHIVE_NUM;
    }

    public void setINTIME_TO_ARCHIVE_NUM(String INTIME_TO_ARCHIVE_NUM) {
        this.INTIME_TO_ARCHIVE_NUM = INTIME_TO_ARCHIVE_NUM;
    }

    public String getINTIME_ARCHIVE_NUM() {
        return INTIME_ARCHIVE_NUM;
    }

    public void setINTIME_ARCHIVE_NUM(String INTIME_ARCHIVE_NUM) {
        this.INTIME_ARCHIVE_NUM = INTIME_ARCHIVE_NUM;
    }

    public String getEVENT_PROPERTY_NAME() {
        return EVENT_PROPERTY_NAME;
    }

    public void setEVENT_PROPERTY_NAME(String EVENT_PROPERTY_NAME) {
        this.EVENT_PROPERTY_NAME = EVENT_PROPERTY_NAME;
    }
}
