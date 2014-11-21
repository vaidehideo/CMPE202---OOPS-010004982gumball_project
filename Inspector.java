import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class Inspector extends Alien
{
   private ArrayList<Picker> pickers = new ArrayList<Picker>(); //Array list to chose one of the picker randomly
   Message m = new Message();
   
    public void addPicker(Picker obj)
    {
        pickers.add(obj);
    }
    
    public void removePicker(Picker obj)
    {
        pickers.remove(obj);
    }
    
    //Set message for Inspector
    public void setMessage(String msg)
    {
        World world = getWorld();
        if (m.getWorld() != null)
        {
            world.removeObject(m);
        }
        world.addObject(m, 533, 350);
        m.setText(msg);
    }
    
    public Message getMessageObj()
    {
        return this.m;
    }
    
    public void inspect(Coin coin)
    {
        this.setMessage(coin.getClass().getName());
        GumballWorld gb = (GumballWorld) getWorld();
        
        //If Quarter then proceed with chosing gumball
        if(coin.getClass()==Quarter.class)
        {
            int whichPicker = Greenfoot.getRandomNumber(pickers.size()); //Get randomnumber to select a picker
            Picker pickerChosen = pickers.get(whichPicker);
            gb.instructions("Here is your Gumball");
            Greenfoot.playSound("Quarter.wav");
            pickerChosen.pick();
        }
            
        //If Penny or Fake Quarter then return the coin and display message 
        if (coin.getClass()==Penny.class)
        {
            gb.instructions("Try a Quarter");
            Greenfoot.playSound("Not.wav");
            World world = getWorld();
            world.addObject( new Penny(), 57, 71 ) ;
        }
        
        if (coin.getClass()==FakeQuarter.class)
        {
            gb.instructions("Try a Real Quarter");
            Greenfoot.playSound("Not.wav");
            World world = getWorld();
            world.addObject( new FakeQuarter(), 66, 248 ) ;
        }
    }
}
