package com.example.veronica.historyfanatics;

/**
 * Created by Veronica on 5/13/2019.
 */
public class Story
{
    private int year;
    private String title;
    private String story;

    public Story(int Year, String Title,String Story)
    {
        year = Year;
        title = Title;
        story = Story;
    }
    public int getYear(){return year;}
    public String getTitle(){return title;}
    public String getStory(){return story;}
}
