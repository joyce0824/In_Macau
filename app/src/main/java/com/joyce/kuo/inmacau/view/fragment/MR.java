package com.joyce.kuo.inmacau.view.fragment;

/**
 * Created by apple on 16/8/14.
 */
public class MR {
    public String AREA;
    public String ID;
    public String NAME;
    public String NOTE;
    public float LAT;
    public float LNG;

    public MR(String area,String id, String name,String note,float lat,float lng)
    {
        AREA=area;
        ID=id;
        NAME=name;
        NOTE=note;
        LAT=lat;
        LNG=lng;
    }
    public MR(String id, String name,String note)
    {
        ID=id;
        NAME=name;
        NOTE=note;

    }

}
