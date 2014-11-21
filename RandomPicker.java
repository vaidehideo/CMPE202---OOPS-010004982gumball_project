import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class RandomPicker extends Picker
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
        world.addObject(m, 643, 154);
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
    	//Select random numver from 3 to choose one gumball and display
        int whichball = Greenfoot.getRandomNumber(3);
    	switch( whichball )
    	{
    		case 0: gb = new BlueGumball(); break;
    		case 1: gb = new RedGumball(); break;
    		case 2: gb = new GreenGumball(); break;
    	}
    	World world = getWorld();
    	world.addObject(gb, 500, 500);
    	this.setMessage("I'm Random");
    }    
}
