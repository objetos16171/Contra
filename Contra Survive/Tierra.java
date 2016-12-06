import greenfoot.*;
 
/**
 *  Crea la clase de los enemigos Tipo Cielo  con sus caracteristicas   
 * 
 * @author Anguiano Garcia Alfredo,Juárez Jalomo Ana Paola 
 *
 * @version (1.1 Beta)
 */
public class Tierra extends Enemigo
{  
     private int tamX=51,tamY=66;
    private String archivo = "VillanoTierra/Tder2.png";
    private String imaIzq ="VillanoTierra/Tizq2.png";
    private String imaDer ="VillanoTierra/Tder2.png";
    

    private int numSpr=4;
    private int limIzq,limDer;
    private SimpleTimer time;
    private Bomb bom;
    public Tierra(int Izq, int Der)
    {
        super("VillanoTierra/Tder2.png");
          limIzq= Izq;
        limDer= Der;
         bom= new Bomb();
    }
    
    /**
     * Act - do whatever the EnemigoC wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(archivo,tamX,tamY,imaIzq,imaDer,numSpr,limIzq,limDer);
        
        
        addM();
    }   
    
    public void addM()
    {
        World m= (WorldMo) getWorld();
        
        if(super.getClado()==1)
        {
               // System.out.println("Entro........ Y NO LO CREA??"); 
                
            m.addObject(bom,getX(),getY()); 
            bom.setLocation(Greenfoot.getRandomNumber(800), getY());
            Clado=0;
        }
    }
}
