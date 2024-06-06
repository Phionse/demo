package com.example.demo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 广播设备信息及预警终端
 */
@Data
public class BroadcastingFormal implements Serializable {
    private Long id;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 设备资源码
     */
    private String deviceResourceCode;

    /**
     * 设备状态
     */
    private String deviceStatus;

    /**
     * 村
     */
    private String village;

    /**
     * 设备纬度
     */
    private String lat;

    /**
     * 设备经度
     */
    private String lon;

    /**
     * 设备所处省
     */
    private String province;

    /**
     * 设备所处区县
     */
    private String area;

    /**
     * 设备所处市
     */
    private String city;

    /**
     * 设备所处乡镇
     */
    private String town;

    /**
     * 安装位置
     */
    private String installationPosition;

    /**
     * 自然村
     */
    private String naturalVillage;

    /**
     * 烈度
     */
    private String intensity;

    /**
     * 震级
     */
    private String m;

    /**
     * 长轴长度
     */
    private String da;

    /**
     * 短轴长度
     */
    private String db;

    /**
     * 震中距离
     */
    private Double distance;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceResourceCode() {
        return deviceResourceCode;
    }

    public void setDeviceResourceCode(String deviceResourceCode) {
        this.deviceResourceCode = deviceResourceCode;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getInstallationPosition() {
        return installationPosition;
    }

    public void setInstallationPosition(String installationPosition) {
        this.installationPosition = installationPosition;
    }

    public String getNaturalVillage() {
        return naturalVillage;
    }

    public void setNaturalVillage(String naturalVillage) {
        this.naturalVillage = naturalVillage;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getDa() {
        return da;
    }

    public void setDa(String da) {
        this.da = da;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deviceName=").append(deviceName);
        sb.append(", deviceResourceCode=").append(deviceResourceCode);
        sb.append(", deviceStatus=").append(deviceStatus);
        sb.append(", village=").append(village);
        sb.append(", lat=").append(lat);
        sb.append(", lon=").append(lon);
        sb.append(", province=").append(province);
        sb.append(", area=").append(area);
        sb.append(", city=").append(city);
        sb.append(", town=").append(town);
        sb.append(", installationPosition=").append(installationPosition);
        sb.append(", naturalVillage=").append(naturalVillage);
        sb.append(", intensity=").append(intensity);
        sb.append(", m=").append(m);
        sb.append(", da=").append(da);
        sb.append(", db=").append(db);
        sb.append(", distance=").append(distance);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BroadcastingFormal other = (BroadcastingFormal) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getDeviceName() == null ? other.getDeviceName() == null : this.getDeviceName().equals(other.getDeviceName()))
                && (this.getDeviceResourceCode() == null ? other.getDeviceResourceCode() == null : this.getDeviceResourceCode().equals(other.getDeviceResourceCode()))
                && (this.getDeviceStatus() == null ? other.getDeviceStatus() == null : this.getDeviceStatus().equals(other.getDeviceStatus()))
                && (this.getVillage() == null ? other.getVillage() == null : this.getVillage().equals(other.getVillage()))
                && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()))
                && (this.getLon() == null ? other.getLon() == null : this.getLon().equals(other.getLon()))
                && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
                && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
                && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
                && (this.getTown() == null ? other.getTown() == null : this.getTown().equals(other.getTown()))
                && (this.getInstallationPosition() == null ? other.getInstallationPosition() == null : this.getInstallationPosition().equals(other.getInstallationPosition()))
                && (this.getNaturalVillage() == null ? other.getNaturalVillage() == null : this.getNaturalVillage().equals(other.getNaturalVillage()))
                && (this.getIntensity() == null ? other.getIntensity() == null : this.getIntensity().equals(other.getIntensity()))
                && (this.getM() == null ? other.getM() == null : this.getM().equals(other.getM()))
                && (this.getDa() == null ? other.getDa() == null : this.getDa().equals(other.getDa()))
                && (this.getDb() == null ? other.getDb() == null : this.getDb().equals(other.getDb()))
                && (this.getDistance() == null ? other.getDistance() == null : this.getDistance().equals(other.getDistance()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeviceName() == null) ? 0 : getDeviceName().hashCode());
        result = prime * result + ((getDeviceResourceCode() == null) ? 0 : getDeviceResourceCode().hashCode());
        result = prime * result + ((getDeviceStatus() == null) ? 0 : getDeviceStatus().hashCode());
        result = prime * result + ((getVillage() == null) ? 0 : getVillage().hashCode());
        result = prime * result + ((getLat() == null) ? 0 : getLat().hashCode());
        result = prime * result + ((getLon() == null) ? 0 : getLon().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getTown() == null) ? 0 : getTown().hashCode());
        result = prime * result + ((getInstallationPosition() == null) ? 0 : getInstallationPosition().hashCode());
        result = prime * result + ((getNaturalVillage() == null) ? 0 : getNaturalVillage().hashCode());
        result = prime * result + ((getIntensity() == null) ? 0 : getIntensity().hashCode());
        result = prime * result + ((getM() == null) ? 0 : getM().hashCode());
        result = prime * result + ((getDa() == null) ? 0 : getDa().hashCode());
        result = prime * result + ((getDb() == null) ? 0 : getDb().hashCode());
        result = prime * result + ((getDistance() == null) ? 0 : getDistance().hashCode());
        return result;
    }
}