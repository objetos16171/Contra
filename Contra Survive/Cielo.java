import greenfoot.*;
 
/**
 * Crea la clase de los enemigos Tipo Tierra  con sus caracteristicas   
 *  
 * @author Anguiano Garcia Alfredo,Juárez Jalomo Ana Paola
 * @version (1.1 Beta)
 */
public class Cielo extends Enemigo
{
  
    
    
        private int tamX=48,tamY=61;
    private String archivo = "VillanoCielo/Der.png";
    private String imaIzq ="VillanoCielo/"+"Izq.png"; 
    private String imaDer ="VillanoCielo/"+"Der.png";
    
    private int numSpr=4;
    private int limIzq,limDer,bandX; 
    private SimpleTimer time,Oclok;
    private Ball bal;
    private  int zban=0;
    private int actLado=1;
    public Cielo(int Izq, int Der)
    {

         super("VillanoCielo/Der.png"); 
        limIzq= Izq;
        limDer= Der;
        time = new SimpleTimer();
        Oclok = new SimpleTimer();
        bal= new Ball();
    }  
    
    
    /**
     * Act - do whatever the EnemigoT wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
     
         
      
        if( super.getTlado()==0 ){
     
          move(archivo,tamX,tamY,imaIzq,imaDer,numSpr,limIzq,limDer);
        }
       
           //System.out.println("B:"+Tlado);
        
       
        
         VerifDisp();
       
    }    
    
    
    
    
    public void VerifDisp()
    {
         World mundo = (WorldMo) getWorld();
        
          //int Dx =getX();m= (WorldMo)getWorld()

          
        if(time.millisElapsed()>10000)
          {
             
              Tlado=0;  
              zban=0;
            time.mark();
            
             
          }
         
           if(isTouching(Ej.class) && zban==0) /*|| isTouching(ExtI.class) && zban==0 )*/ //verificaIzq=2 <-Tlado  && Tlado==2
             {   
                /*if(Tlado==2)
                {
                  actLado=0;  
                }
                else
                {
                    actLado=1;
                }*/
                
                if(Tlado==2)
                {
                    if(Oclok.millisElapsed()<20   )//<4300 
                        {
                            System.out.println("SIII lo TOCAA :");
                            System.out.println("SiLEFT:"+Oclok.millisElapsed());
                           
                            mundo.addObject(bal,getX(),getY());  
                            bal.setLocation(getX(), getY());
                            //Greenfoot.stop();
                            zban=1;
                        }    
                        actLado=0;  
                }
                
                if(Tlado==1)
                {
                    if(Oclok.millisElapsed()<4300   )//<4300 
                        {
                           // System.out.println("SIII lo TOCAA :");
                            //System.out.println("SiLEFT:"+Oclok.millisElapsed());
                           
                            mundo.addObject(bal,getX(),getY());  
                            bal.setLocation(getX(), getY());
                            //Greenfoot.stop();
                            zban=1;
                        }    
                        actLado=1;  
                }
                
                
                    Oclok.mark();
             }
             
             if(actLado==0)
             {
                 bal.move(2);
             }
              if(actLado==1)
             {
                 bal.move(-2);
             }
             
            
           
        
    }
    
    public int GetactLado()
    {
        return actLado;
    }
    
}
