package com.furkanturkmen.geoguessswipe;

public class GeoObject {

    private String geoName;
    private boolean geoEurope;
    private int geoId;

    public GeoObject(String geoName, int geoId, boolean geoEurope) {
        this.geoName = geoName;
        this.geoEurope = geoEurope;
        this.geoId = geoId;
    }

    public String getGeoName() {
        return geoName;
    }

    public void setGeoName(String geoName) {
        this.geoName = geoName;
    }

    public int getGeoId() {
        return geoId;
    }

    public void setGeoId(int geoId) {
        this.geoId = geoId;
    }

    public boolean isGeoEurope() {
        return geoEurope;
    }

    public void setGeoEurope(boolean geoEurope) {
        this.geoEurope = geoEurope;
    }

    public static final String[] PRE_DEFINED_GEO_OBJECT_NAMES = {
            "Denmark",
            "Canada",
            "Bangladesh",
            "Kazachstan",
            "Colombia",
            "Poland",
            "Malta",
            "Thailand"
    };

    public static final int[] PRE_DEFINED_GEO_OBJECT_IMAGE_IDS = {

            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand,

    };

    public static final boolean[] PRE_DEFINED_GEO_OBJECT_IMAGE_EUROPES = {
            true,
            false,
            false,
            true,
            false,
            true,
            true,
            false
    };



}
