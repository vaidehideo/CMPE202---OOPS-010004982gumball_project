import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GumballWorld extends World
{

    private Inspector inspector;
    private GumballMachine gumballmachine;
    private RandomPicker randompicker;
    private GreenPicker greenpicker;
    public GumballWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }

    private void prepare()
    {
        gumballmachine = new GumballMachine();
        addObject(gumballmachine, 367, 237);
        addObject( new Penny(), 57, 71 ) ;
        addObject( new Quarter(), 68, 156 ) ;
        addObject( new FakeQuarter(), 66, 248 ) ;
        inspector = new Inspector();
        addObject(inspector, 533, 291);
        randompicker = new RandomPicker();
        addObject(randompicker, 643, 104);
        randompicker.setLocation(655, 94);
        greenpicker = new GreenPicker();
        addObject(greenpicker, 686, 454);
        greenpicker.setLocation(669, 456);
        Quarter quarter2 = new Quarter();
        addObject(quarter2, 157, 426);
        quarter2.setLocation(67, 354);
        
        inspector.addPicker(randompicker);
        inspector.addPicker(greenpicker);
        this.instructions("Drag coin to machine");
    }
     
    //To display step guideline messages for user
    public void instructions(String msg)
    {
        Message m = new Message();
        addObject(m, 367,550);
        m.setText(msg);
    }
    
    //Getter methods-
    public Inspector getInspector()
    {
        return this.inspector;
    }
    
    public GumballMachine getGumballMachine()
    {
        return this.gumballmachine;
    }
    
    public RandomPicker getRandomPicker()
    {
        return this.randompicker;
    }
    
    public GreenPicker getGreenPicker()
    {
        return this.greenpicker;
    }
    
}
