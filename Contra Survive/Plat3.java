import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plat3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plat3 extends Plataforma
{

    private int actMove = -3;
    int x,y,z;
    
    /**
     * Act - do whatever the Plat1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Plat3(int x,int y)
    {
        setImage("plat_2.png");
        this.x = x;
        this.y = z =y;
    }
    
    public void act() 
    {
        // Add your action code here.
        y=y+actMove;
        setLocation(x,y);
        if(getY()==z)
        {
            actMove=-3;
            
        }
        else if(getY()==z-200)
        {
            actMove=+3;
        }
        
         super.selectImage();
    } 
}
