import greenfoot.*;

/**
 * Write a description of class Plat1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plat1 extends Plataforma
{

    private int actMove = 2;
    
    /**
     * Act - do whatever the Plat1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Plat1()
    {
        setImage("plat_2.png");
    }
    
    public void act() 
    {
        // Add your action code here.
        
        move(actMove);
        if(getX()>=760)
        {
            actMove=-4;
            
        }
        else if(getX()<=60)
        {
            actMove=4;
        }
        
        super.selectImage();
    }    
}
