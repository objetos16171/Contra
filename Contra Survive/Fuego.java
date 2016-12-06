import greenfoot.*; 


/**
 *  Crea la clase de los enemigos Tipo Fuego  con sus caracteristicas   
 * 
 * @author Anguiano Garcia Alfredo,Juárez Jalomo Ana Paola
 *
 * @version (1.1 Beta)
 */
public class Fuego extends Enemigo
{
    private int tamX=78,tamY=75; 
     private String archivo = "Villanofuego/Der.png";
     private String imaIzq ="Villanofuego/Izq.png";
     private String imaDer ="Villanofuego/Der.png"; 
     //archivo = "Comun/"+"Izq.png"; 
     private int numSpr=4; 
     private int limIzq,limDer;
   // private int[][] Posicion = new int[5][2];
    
    public Fuego(int limI,int limD )
    {
         super("Villanofuego/Der.png");
         limIzq=limI;
         limDer=limD;
         
                                 
    }
    
    /**
     * Act - do whatever the Fuego wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
         move(archivo,tamX,tamY,"Villanofuego/Izq.png","Villanofuego/Der.png",numSpr,limIzq,limDer);
    }    
    
    /*public int [][] GetArrPos()
    {
        
        return Posicion;
    }*/
}
