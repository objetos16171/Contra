import greenfoot.*;

/**
 * Write a description of class Heroe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heroe extends Actor
{
    
    private   double dy = 0;
    private double g = 1;
    private  double BOSST_SPEED = -6;
    private boolean bandSalto;
    protected static int boom, Hy, Hx,vlado,bandTE=0;
    
    private GreenfootImage img;
    private String archivo = "Naruto/piecitos.png";
    
       

    
 
   
    
    public Heroe ()
    {
        img = new GreenfootImage(archivo);
        setImage(archivo);
    }
    
    /**
     * Act - do whatever the Don wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Hy = getY();
        Hx = getX();
        int oY;
        
        move();
        verificaPos();
        verifExtremo();
        verificaT();
        
     }   
    
    public void verificaT()
    {
        if(isTouching(barrV.class)&&vlado==1)
        {
            setLocation(getX()-10,getY());
        }
        else if(isTouching(barrV.class)&&vlado==0)
        {
            setLocation(getX()+10,getY());
        }
        if(isTouching(barrH.class))
        {
            setLocation(getX(),getY()+10);
        }
        
    }
      
     /**
      * Aqui verificamos que el heroe se encuente dentro del area de juego y si no esta sobre algun objeto "solido", la gravedad lo aga caer
      * bandSalto: es una bandera que sirve para que el personaje pueda saltar dependiendo donde se encuentre
      */
     public void verifExtremo()
     {
        if(dy<50 && getY()<=599 )//575
        {
             if(isTouching(Plat2.class)||isTouching(Plat1.class))
             {
                 //setLocation(getX(),370); 
                 setLocation(getX(),getY());
                 bandSalto = true;
                 boom=1;
                 Hy = getY();
                 Hx = getX();
             }
             else
             {
                 dy = dy + (g/3);
                 setLocation(getX(), (int)(getY()+ dy));
                 boom=0;
                 Hy = getY();
                 Hx = getX();
             }
         }
         else
         {
           dy=50;
           setLocation(getX(),598); //575
           bandSalto = true;
           Hy = getY();
           Hx = getX();
        }
        if(getX()<0)
        {
           setLocation(0,getY());
           Hy = getY();
           Hx = getX();
        } 
        //System.out.println("heroe"+getY());
     }
   
    public void move()
    {
        int positionX,positionY;
        
        positionX=getX();
        positionY=getY(); 
        
        if(Greenfoot.isKeyDown("Right"))
        {
            setLocation(positionX+5,positionY);
            vlado=1;
        }
        
         if(Greenfoot.isKeyDown("Left"))
        {
            setLocation(positionX-5,positionY);
            vlado=0;
        }
        
        if(Greenfoot.isKeyDown("up") )
         {
            if(bandSalto)
            {
                dy = BOSST_SPEED;
                bandSalto = false;   
            }
            setLocation(positionX,(int)(positionY + dy));
         }
   } 
   
   public int regresaX()
   {
       return getX();
   }
   
   public int regresaY()
   {
       return getY();
   }
   
   public void verificaPos()
   {
       if(bandTE==1)
       {
           setLocation(60,1450);
           bandTE=0;
       }
   }
}
