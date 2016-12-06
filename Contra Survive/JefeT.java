import greenfoot.*;
/**
 *  Crea la clase del  Jefe del nivel Tipo Tierra  con sus caracteristicas   
 * 
  * @author Anguiano Garcia Alfredo,Juárez Jalomo Ana Paola
 * 
 * @version (1.1 Beta)
 */
public class JefeT extends Enemigo
{
   private int tamX=80,tamY=81;
   private int numSpr=3;
   private String archivo = "JefeTierra/Der.png";
   private String imaIzq ="JefeTierra/Izq.png";
   private String imaDer ="JefeTierra/Der.png";
   private int limIzq,limDer;
   private SimpleTimer time;
   private int numRand;
   private Rock Rk,Rk2,Rk3;
   
    public JefeT(int Izq, int Der)
   {
       super("JefeTierra/Der.png");
       limIzq= Izq;
       limDer= Der;
       time = new SimpleTimer();
       Rk= new Rock();
       Rk2= new Rock();
       Rk3= new Rock();
   }
   /**
     * Act - do whatever the JefeT wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        LanzaRk();
        
        
        
        
   
        } 
       
        
            
    /**
    Hace que el Jefe lance rocas con un cierto angulo 
     */
   public void LanzaRk()
    {
        World m = (WorldMo) getWorld();
         if(time.millisElapsed()<2500)//10000
        {
            move(archivo,tamX,tamY,imaIzq,imaDer,numSpr,limIzq,limDer); 
            
            // System.out.println("RANDOOM : "+ Rvar); 
        }   
        
        if(time.millisElapsed()>2500 && time.millisElapsed()<2518)// 10000 &&10018
         {
                 
          
           System.out.println("ENTRO al 3 : "); 
           m.addObject(Rk,getX(),getY());  
           Rk.setLocation(getX(), getY());
           
            m.addObject(Rk2,getX(),getY());  
           Rk2.setLocation(getX(), getY());
            
            m.addObject(Rk3,getX(),getY());  
           Rk3.setLocation(getX(), getY());
           
          numRand= Greenfoot.getRandomNumber(90)+Greenfoot.getRandomNumber(60);
           Rk.setRotation(numRand);
           
           numRand= (Greenfoot.getRandomNumber(20)+20)+(Greenfoot.getRandomNumber(40)+50);
           Rk2.setRotation(numRand);
           
           numRand= Greenfoot.getRandomNumber(30)+(Greenfoot.getRandomNumber(10)+15);
           Rk3.setRotation(numRand);
          //Greenfoot.stop();
         } 
          if(time.millisElapsed()<6000 && time.millisElapsed()>2500) //15000 &&10000
        {
          
           //Rk.mo();
           Rk.move(3);
           Rk2.move(3);
           Rk3.move(3);
        }
         if(time.millisElapsed()>6000)//15000
        {
           //m.removeObjects(m.getObjects(Rock.class));
            time.mark();  
        }   
        
        
    }
      
    
    }
    

