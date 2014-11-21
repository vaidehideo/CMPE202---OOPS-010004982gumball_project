import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class GumballMachine extends Actor
{
    Message m = new Message();
    Actor haveCoin;

    public GumballMachine()
    {
        GreenfootImage image = getImage() ;
        image.scale( 350, 400 ) ; 
    }
    
    //To display messages on gumball machine where the mouse is
    public void setMessage(String msg)
    {
        int mouseX, mouseY ;
        MouseInfo mouse = Greenfoot.getMouseInfo();  
        mouseX=mouse.getX();  
        mouseY=mouse.getY();
        World world = getWorld();
        if (m.getWorld() != null)
        {
            world.removeObject(m);
        }
        world.addObject(m, mouseX, mouseY);
        m.setText(msg);
    }
    
    public void act() 
    {
        GumballWorld gb = (GumballWorld) getWorld();
        Inspector inspector = gb.getInspector();
        GreenPicker greenpicker = gb.getGreenPicker();
        RandomPicker randompicker = gb.getRandomPicker();
        
        //invoked when Gumball machine's crank is turned
        if(Greenfoot.mousePressed(this))
        {
            //If crank is turned without putting any coin
            if(haveCoin == null)
                setMessage("Give me coin :(");
            //If coin is inserted, Call inspector's code to validate the coin and proceed 
            else
            {
                setMessage("Crank Turned :D");
                gb.instructions("Wait for inspector");
                inspector.inspect((Coin)haveCoin);
            }
        }
        
        //Invoked when coin is inserted to the machine 
        Actor coin = getOneObjectAtOffset( +10, +10, Coin.class) ;
        if(coin != null)
        {
            //Reset all to be able to get new coin
            if(haveCoin != null)
            {
                //Reset all to get new coin
                haveCoin = null;
                Message m1 = inspector.getMessageObj();
                Message m2 = greenpicker.getMessageObj();
                Message m3 = randompicker.getMessageObj();
                Gumball g1 = greenpicker.getGumBallObj();
                Gumball g2 = randompicker.getGumBallObj();
                World world = getWorld();
                world.removeObject(m1);
                if (m2 != null) world.removeObject(m2);
                if (m3 != null) world.removeObject(m3);
                if (g1 != null) world.removeObject(g1);
                if (g2 != null) world.removeObject(g2);
            }
            //Get the coin, display 'Have coin', call inslot to remove coin from the GumballWorld
            else
            {
                haveCoin = coin;
                setMessage("Have Coin =)");
                Greenfoot.playSound("Coin.wav");
                gb.instructions("Turn the Crank");
                ((Coin)coin).inSlot();
            }
        }
    }
}
