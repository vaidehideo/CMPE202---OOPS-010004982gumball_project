import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Message extends Actor
{
    GreenfootImage gi;
    
    public Message()
        {
           gi=new GreenfootImage(150,30);
           setImage(gi);
        }
       
    public void setText(String msg)
    {
            gi.clear();
            gi.setColor(java.awt.Color.PINK);
            gi.fill();
            gi.setColor(java.awt.Color.BLACK);
            gi.drawString(msg,0,25);
    }
    
    public void act() 
    {
        if (Greenfoot.mousePressed(this))
        {
           World world =getWorld();
           world.removeObject(this);
        }
    }    
}
