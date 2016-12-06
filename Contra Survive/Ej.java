import greenfoot.*;
 
/**
 * Esta clase ayuda a verificar los extremos para  el enmeigo Tierra 
 * 
 * @author Anguiano Garcia Alfredo,Juárez Jalomo Ana Paola
 *
 * @version (1.1 Beta)
 */
public class Ej extends Actor
{
     private Fuego fu;
     private int xp;
     public static int numX,bandEj=0;
     private int[][] Pos = new int[5][2]; 
     //private int bandEj=0;
    public Ej()
    {
        //fi = new Fuego(); 
        
           Pos [0][0]=350; //pos X
        Pos [0][1]=1450;//pos Y
         
        Pos [1][0]=150;
        Pos [1][1]=1400;
         
         Pos [2][0]=500;
         Pos[2][1]=1350;
         
         Pos [3][0]=150;
         Pos [3][1]=1300;
         
         Pos [4][0]=500;
         Pos [4][1]=1250;
         
       
        
         fu= new Fuego (100,400);
    } 
     
     /**
     * Act - do whatever the Bonificacion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //SetRandoomPos();
      
    }    
    
     /**
    Hace que el enemigo fuego aparezca en posiciones aleatorias
     */
    
    public void SetRandoomPos()
    {
        World m = (WorldMo) getWorld();
   
        if(isTouching(Fuego.class))
        {
            removeTouching(Fuego.class);
           
           //
           bandEj=1;
            
            numX=Greenfoot.getRandomNumber(4);
            System.out.println("numALE : "+numX );
            //numY=Greenfoot.getRandomNumber(2);
            
            
            if(numX==0 || numX==1 || numX==2 || numX==3)//(GetPos[numX][0]-100),(GetPos[numX][1]+300)
            {
                
        
                fu = new Fuego((Pos[numX][0]-100),(Pos[numX][1]+300));
                m.addObject(fu,Pos[numX][0],Pos[numX][1]);
                fu.setLocation(Pos[numX][0],Pos[numX][1]);
                 System.out.println("numXArr : "+Pos[numX][0] );
                //Greenfoot.stop();
            }
            //
            System.out.println("bandera EJSuMunDO : " + GetBandEj());
             
        }
    }
    
    
     /**
     * Bandera de la clase
     */
    public int GetBandEj()
    {
        return bandEj; 
    }
    
    public void cambiabnd()
    {
        bandEj = 0;
    }
}
