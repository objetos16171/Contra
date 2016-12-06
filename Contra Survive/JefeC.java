import greenfoot.*;
 
/**
 *  Crea la clase del  Jefe del nivel Tipo Cielo  con sus caracteristicas   
 * 
 * @author Anguiano Garcia Alfredo,Juárez Jalomo Ana Paola
 *
 * @version (1.1 Beta)
 */
public class JefeC extends Actor
{
    private int x, y,z=0,actMove=-4;
    private SimpleTimer time;
    private BSky bCielo;
    private Rayo Ry;
    public JefeC(int x, int y)
    {
      this.x=x;
      this.y=y;
      time= new SimpleTimer();
      bCielo= new BSky ();
       Ry= new Rayo ();
    }
    
    public void act()
    { 
      
         disparaBola();
    }
   
    /**
     * Hace que el Jefe se mueva de modo vertical
     */
    public void mueve()
    {
          y=y+actMove;
        setLocation(x,y);
        if(y<=50)
       {
             actMove=4;
             
       }
      else if(y>=550)
      {
          actMove=-4;
      }
      
      
    
    } 
    
       /**
     * Hace que las verificaciones de los disparos 
     */
    public void disparaBola()
    {
       World m = (WorldMo) getWorld();
        if(time.millisElapsed()<2500)
      {
          mueve(); 
      }
      else if(time.millisElapsed()>2500 && time.millisElapsed()<2518 && z!=4)
      {
           m.addObject(bCielo,getX(),getY());  
            bCielo.setLocation(getX(), getY());
          
      }
      if(z==4)
      {   
          if(time.millisElapsed()>2500 && time.millisElapsed()<2518)
          {
               m.addObject(Ry,getX(),getY());  
            Ry.setLocation(getX(), getY()); 
              System.out.println("ooooou: "); 
              z=0;
          }
         
      }
      if(time.millisElapsed()>7000)//15000
        {
           //m.removeObjects(m.getObjects(BSky.class));
           
           
           
            time.mark(); 
            z++;
        }   
      
        
        System.out.println("Z: " + z);
    }
}
    
   
    
    
 

