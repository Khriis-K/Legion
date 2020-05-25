import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    int frameCount = 0;
    int preCount = 0;
    GreenfootSound titleMusic = new GreenfootSound("music/TitleScreen.mp3");
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }
    
    private void prepare()
    {
        this.setBackground("TitleScreen/TitleScreen0.png");
        /*Jumper jumper = new Jumper();
        addObject(jumper,0,0);
        
        Platform platform = new Platform(200, 100);
        addObject(platform, 100, 0);
        
        Ladder ladder = new Ladder(50, 400);
        addObject(ladder, 600, 500); */
    }
    
    public void act() 
    {
        if (frameCount == 0)
        {
            FilmGrain grain = new FilmGrain();
            addObject(grain, 400, 300);
        }
        if (preCount <= 45)
        {
            preCount++;
        }
        if (frameCount == 0)
        {
            titleMusic.playLoop();
        }
        if (preCount > 45 && frameCount <= 121)
        {
            String image = "TitleScreen/TitleScreen" + frameCount + ".png";
            this.setBackground(image);
            frameCount++;
        }
    }
    
    public void stopped()
    {
        titleMusic.stop();
    }
}
