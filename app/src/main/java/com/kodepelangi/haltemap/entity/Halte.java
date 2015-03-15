package com.kodepelangi.haltemap.entity;

/**
 * Halte Entity
 * @author Raka Teja<rakatejaa@gmail.com>
 */
public class Halte {
    private String HalteName;
    private String KoridorNo;
    private double Long;
    private double Lat;
    private int HalteType;

    public String getHalteName() {
        return HalteName;
    }

    public void setHalteName(String halteName) {
        HalteName = halteName;
    }

    public String getKoridorNo() {
        return KoridorNo;
    }

    public void setKoridorNo(String koridorNo) {
        KoridorNo = koridorNo;
    }

    public double getLong() {
        return Long;
    }

    public void setLong(double aLong) {
        Long = aLong;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(double lat) {
        Lat = lat;
    }

    public int getHalteType() {
        return HalteType;
    }

    public void setHalteType(int halteType) {
        HalteType = halteType;
    }
}
