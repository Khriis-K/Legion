import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* Write a description of class Jumper here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class Jumper extends Actor
{
    private final int GRAVITY = 1;
    private final int STEP = 5;
    private int velocity;
    
    public Jumper()
    {
        velocity = 0;
    }
    
    public void act() 
    {
        fall();
        if (Greenfoot.isKeyDown("space") && isOnSolidGround())
        {   
            jump();
        }
        move();
    } 
    
    public void fall()
    {
        setLocation(getX(), getY() + velocity);
        if (isOnSolidGround())
        {
            velocity = 0;
            while(isOnSolidGround())
            {
                setLocation(getX(), getY() - 1);
            }
            setLocation(getX(), getY() + 1);
        }
        else if(velocity < 0 && didBumpHead())
        {
            velocity = 0;
            while (didBumpHead())
            {
                setLocation(getX(), getY() + 1);
            }
        }
        else if(canClimb())
        {
            velocity = 0;
        }
        else
            velocity += GRAVITY;
    }
    
    public void jump()
    {
        velocity = -20;
    }
    
    public void move()
    {
        int y = getY();
        int x = getX();
        if(Greenfoot.isKeyDown("left") && canMoveLeft())
            x -= STEP;
        if(Greenfoot.isKeyDown("right") && canMoveRight())
            x += STEP;
        if(Greenfoot.isKeyDown("up") && canClimb())
            y -= STEP;
        setLocation(x, y);
    }
    
    public boolean isOnSolidGround()
    {
        boolean isOnGround = false;
        if (getY() > getWorld().getHeight() - 50)
            isOnGround = true;
        
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        if (getOneObjectAtOffset(imageWidth / -2, imageHeight / 2, Platform.class) != null ||
            getOneObjectAtOffset(imageWidth / 2, imageHeight / 2, Platform.class) != null) // if touching platform
            isOnGround = true;
        return isOnGround;
    }
    
    public boolean didBumpHead()
    {
        boolean bumpedHead = false;
        
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        if (getOneObjectAtOffset(imageWidth / -2, imageHeight / -2, Platform.class) != null ||
            getOneObjectAtOffset(imageWidth / 2, imageHeight / -2, Platform.class) != null) // if touching platform 
            bumpedHead = true;
            
        return bumpedHead;
    }
    
    public boolean canMoveLeft()
    {
        boolean canMoveLeft = true;
        
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        if (getOneObjectAtOffset(imageWidth / -2 - STEP, imageHeight / -2, Platform.class) != null ||
            getOneObjectAtOffset(imageWidth / -2 - STEP, imageHeight / 2 - 1, Platform.class) != null) // if touching platform 
            canMoveLeft = false;
            
        return canMoveLeft;
    }
    
    public boolean canMoveRight()
    {
        boolean canMoveRight = true;
        
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        if (getOneObjectAtOffset(imageWidth / 2 + STEP, imageHeight / -2, Platform.class) != null ||
            getOneObjectAtOffset(imageWidth / 2 + STEP, imageHeight / 2 - 1, Platform.class) != null) // if touching platform 
            canMoveRight = false;
            
        return canMoveRight;
    }
    
    public boolean canClimb()
    {
        if (isTouching(Ladder.class))
            return true;
        return false;
    }
}
