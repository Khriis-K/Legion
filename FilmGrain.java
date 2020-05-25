import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FilmGrain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FilmGrain extends Actor
{
    int grainFrame = 0;
    int frameCount = 0;
    
    public FilmGrain()
    {
    }
    
    public void act() 
    {
        frameCount++;
        if (frameCount % 3 == 0)
        {
            frameCount = 0;
            this.setImage("FilmGrain/frame" + grainFrame + ".png");
            if (grainFrame == 23)
                grainFrame = 0;
            else
                grainFrame++;
        }
        
    }    
}
