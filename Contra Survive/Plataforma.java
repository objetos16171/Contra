import greenfoot.*;

/**
 * Write a description of class Plataforma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plataforma extends Actor
{
       private WorldMo m;
    /**
     * Act - do whatever the Plataforma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
         selectImage();
    }    
    
    public void selectImage()
    {
         m = (WorldMo) getWorld();
        
        if(m.GetNivel()==1)
        {
           setImage("plat_2.png");
         
           
        }
        else if(m.GetNivel()==2)
        {
            setImage("PlatSky.png");
        }
          else if(m.GetNivel()==3)
        {
             setImage("plat_1.png");
        }
    }
}
