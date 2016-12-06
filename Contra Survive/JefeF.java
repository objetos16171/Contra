import greenfoot.*;

/**
 * Write a description of class JefeF here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JefeF extends Enemigo
{
    private int tamX=128,tamY=128;
   private int numSpr=3;
   private String archivo = "JefeFuego/2.png";
   private String imaIzq ="JefeFuego/1.png";
   private String imaDer ="JefeFuego/2.png";
   private int limIzq,limDer;
   private SimpleTimer time;
   private int numRand;
   private BFire Rk;
   
    public JefeF(int Izq, int Der)
   {
       super("JefeFuego/2.png");
       limIzq= Izq;
       limDer= Der;
       time = new SimpleTimer();
       Rk= new BFire();
    
   }
   /**
     * Act - do whatever the JefeT wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        LanzaFu();
        
        
        
        
   
        } 
       
        
            
    /**
    Hace que el Jefe lance rocas con un cierto angulo 
     */
   public void LanzaFu()
    {
        World m = (WorldMo) getWorld();
         if(time.millisElapsed()<2500)//10000
        {
            move(archivo,tamX,tamY,imaIzq,imaDer,numSpr,limIzq,limDer); 
            
            // System.out.println("RANDOOM : "+ Rvar); 
        }   
        
        if(time.millisElapsed()>2500 && time.millisElapsed()<2518)// 10000 &&10018
         {
                 
          
           //System.out.println("ENTRO al 3 : "); 
           m.addObject(Rk,getX(),getY());  
           Rk.setLocation(getX(), getY());
           
          
           
         
           Rk.setRotation(90);
           
          //Greenfoot.stop();
         } 
          if(time.millisElapsed()<6000 && time.millisElapsed()>2500) //15000 &&10000
        {
          
           //Rk.mo();
           Rk.move(3);
          
        }
         if(time.millisElapsed()>6000)//15000
        {
           //m.removeObjects(m.getObjects(Rock.class));
            time.mark();  
        }   
        
        
    }
      
}
