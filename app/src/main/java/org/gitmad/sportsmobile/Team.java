package org.gitmad.sportsmobile;

/**
 * Created by Andre Giron on 9/6/14.
 */
public class Team {

    private String long_name; //exe. Atlanta Falcons
    private String short_name; //exe. ATL
    private String conference; //exe. NFC South
    private String homeTown;   //Atlanta
    private int imageId; //exe R.id.falcons

    //TODO: Add things like Roster, season record, etc.
    //Each of these will have to be either mocked now, or can be incorporated into the app later.

    public Team(String long_name, String short_name, String conference, String homeTown)
    {
        this.long_name = long_name;
        this.short_name = short_name;
        this.conference = conference;
        this.homeTown = homeTown;
        this.imageId = 0;
    }

    public void setImageId(int imageId)
    {
        this.imageId = imageId;
    }

    public int getImageId()
    {
        return this.imageId;
    }

    public String getShort_name()
    {
        return this.short_name;
    }

    public String getLong_name()
    {
        return this.long_name;
    }

    public String getConference()
    {
        return this.conference;
    }

    public String getHomeTown()
    {
        return this.homeTown;
    }
}
