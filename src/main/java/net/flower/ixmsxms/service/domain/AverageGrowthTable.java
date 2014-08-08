package net.flower.ixmsxms.service.domain;

import java.util.Date;

public class AverageGrowthTable extends BaseObject {
    private Long id;
    private String type;
    private String sex;
    private Long time;
    private Float stature;
    private Float weight;
    private Float headCircumference;
    private Date regDatetime;
    private Date modDatetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Float getStature() {
        return stature;
    }

    public void setStature(Float stature) {
        this.stature = stature;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeadCircumference() {
        return headCircumference;
    }

    public void setHeadCircumference(Float headCircumference) {
        this.headCircumference = headCircumference;
    }

    public Date getRegDatetime() {
        return regDatetime;
    }

    public void setRegDatetime(Date regDatetime) {
        this.regDatetime = regDatetime;
    }

    public Date getModDatetime() {
        return modDatetime;
    }

    public void setModDatetime(Date modDatetime) {
        this.modDatetime = modDatetime;
    }

}