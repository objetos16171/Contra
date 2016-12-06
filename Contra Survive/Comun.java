import greenfoot.*; 

/**
 *  Crea la clase de los enemigos Tipo Comun  con sus caracteristicas   
 * 
 * @author Anguiano Garcia Alfredo,Juárez Jalomo Ana Paola
 *
 * @version (1.1 Beta)
 */
public class Comun extends Enemigo
{
    private int tamX=80,tamY=71; 
     private String archivo = "Comun/Der.png";
     private String imaIzq ="Comun/Izq.png";
     private String imaDer ="Comun/Der.png"; 
     //archivo = "Comun/"+"Izq.png"; 
     private int numSpr=4; 
      private int limIzq,limDer;
    public Comun(int Izq,int Der)
    {
        super("Comun/Der.png");
          limIzq= Izq;
        limDer= Der;
    }  
      
      /**
     * Act - do whatever the booL wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(archivo,tamX,tamY,"Comun/"+"Izq.png","Comun/"+"Der.png",numSpr,limIzq,limDer);
    }    
    
    
}
