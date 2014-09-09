package org.gitmad.sportsmobile.model;

public class Team {

    private final String longName; //exe. Atlanta Falcons
    private final String shortName; //exe. ATL
    private final String conference; //exe. NFC South
    private final String homeTown;   //Atlanta
    private final int primaryColor;
    private int imageId; //exe R.id.falcons

    //TODO: Add things like Roster, season record, etc.
    //Each of these will have to be either mocked now, or can be incorporated into the app later.

    public Team(String long_name, String short_name, String conference, String homeTown,
                int primaryColor)
    {
        this.longName = long_name;
        this.shortName = short_name;
        this.conference = conference;
        this.homeTown = homeTown;
        this.primaryColor = primaryColor;
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

    public String getShortName()
    {
        return this.shortName;
    }

    public String getLongName()
    {
        return this.longName;
    }

    public String getConference()
    {
        return this.conference;
    }

    public String getHomeTown()
    {
        return this.homeTown;
    }

    public int getPrimaryColor() {
        return primaryColor;
    }
}
