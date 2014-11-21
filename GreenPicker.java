import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class GreenPicker extends Picker
{
    Message m = new Message();
    Gumball gb = new GreenGumball();
    
    public void setMessage(String msg)
    {
        World world = getWorld();
        if (m.getWorld() != null)
        {
            world.removeObject(m);
        }
        world.addObject(m, 686, 504);
        m.setText(msg);
    }
    
    public Message getMessageObj()
    {
        return this.m;
    }
    
    public Gumball getGumBallObj()
    {
        return this.gb;
    }
    
    public void pick()
    {
    	World world = getWorld();
    	world.addObject(gb, 500, 500);
    	this.setMessage("I like Green 0:)");
    }
}
