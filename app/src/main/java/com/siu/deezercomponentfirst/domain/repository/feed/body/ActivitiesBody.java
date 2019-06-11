package com.siu.deezercomponentfirst.domain.repository.feed.body;

//import android.arch.persistence.room.ColumnInfo;
//import android.arch.persistence.room.Entity;
//import android.arch.persistence.room.Ignore;
//import android.arch.persistence.room.PrimaryKey;
//
//
//@Entity(tableName = "Activities")
//public class ActivitiesBody {
//
//    //dataBase Attribute
//    @ColumnInfo()
//    private int uid;
//    @ColumnInfo
//    private long lastModifiedData;
//    @ColumnInfo
//    private boolean isUpdated;
//    ////////////////////////////////////////////////////////////////////////////
//
//    //body params
//    @PrimaryKey
//    private long time;
//
//    @ColumnInfo
//    private long timeOffset;
//
//    @ColumnInfo
//    private String intensity;
//
//    @ColumnInfo
//    private String duration;
//
//    @ColumnInfo
//    private String tiredness;
//
//    public ActivitiesBody() {
//
//    }
//
//    @Ignore
//    public ActivitiesBody(String intensity,
//                          String duration, String tiredness) {
//
//        this.time       = RdiApplication.getUtcTimeSecond();
//        this.timeOffset = RdiApplication.getLocalTime();
//        this.intensity = intensity;
//        this.duration = duration;
//        this.tiredness = tiredness;
//        this.lastModifiedData = 0L;
//    }
//
//    public long getTime() {
//        return time;
//    }
//
//    public long getTimeOffset() {
//        return timeOffset;
//    }
//
//    public String getIntensity() {
//        return intensity;
//    }
//
//    public String getDuration() {
//        return duration;
//    }
//
//
//    public void setUid(int uid) {
//        this.uid = uid;
//    }
//
//    public void setLastModifiedData(long lastModifiedData) {
//        this.lastModifiedData = lastModifiedData;
//    }
//
//    public void setUpdated(boolean updated) {
//        isUpdated = updated;
//    }
//
//    public void setTime(long time) {
//        this.time = time;
//    }
//
//    public void setTimeOffset(long timeOffset) {
//        this.timeOffset = timeOffset;
//    }
//
//    public void setIntensity(String intensity) {
//        this.intensity = intensity;
//    }
//
//    public void setDuration(String duration) {
//        this.duration = duration;
//    }
//
//
//    public int getUid() {
//        return uid;
//    }
//
//    public long getLastModifiedData() {
//        return lastModifiedData;
//    }
//
//    public boolean isUpdated() {
//        return isUpdated;
//    }
//
//    public String getTiredness() {
//        return tiredness;
//    }
//
//    public void setTiredness(String tiredness) {
//        this.tiredness = tiredness;
//    }
//}
