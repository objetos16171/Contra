import greenfoot.*;

/**
 * En esta clase es donde los enemigos adquieren elmétodo de caminar horizontal 
 * y dodne se hacen verificaciones acorde al tipo de enemigo.
 * 
 * @author Anguiano Garcia Alfredo,Juárez Jalomo Ana Paola 
 * 
 * @version (1.1 Beta)
 */
public class Enemigo extends Actor
{
    private String archivo;/* Nombre de la imagen*/
    private GreenfootImage img ;/* Cuadro de la Imagen */
    private GreenfootImage sprite;
    private int cont=0; 
    private int numSpr,sprAt=8,speed=8,vista;
    private int posX=0;

    private int Band=1,Xb=0;//velocidad del mono
  protected int Tlado=0;
    protected int Clado=0;
    
    private int contSky=0;
    
    public Enemigo(String file)
    {
        this.archivo= file;
        //this.Tlado=Tside;
    }
        
     /** Hace el recorrido de los Sprites
      */
    
    public void spriteNormal(String archivo,int tamX, int tamY,String imaIzq,String imaDer,int numSpr)
    {
        img = new GreenfootImage(archivo);
        GreenfootImage sprite = new GreenfootImage(tamX,tamY);
        //si el contador es mayor a la velocidad de animacion se cambia a la imagen siguiente
       RevisaVista(imaIzq,imaDer);
        if(cont>=speed)//si contador supera speed se cambia la imagen de la animacion
        {

            if(posX > -(tamX*(numSpr-1)))
                posX -= tamX;
            else
                posX = 0;
            sprite.drawImage(img,posX,0);
            setImage(sprite);
            cont=0;
        }
        cont++;
    }
       
    /**Verifica  la vista que tiene el enemigo
      */
    
     public void RevisaVista(String cadenaI, String cadenaD)
   {
      if(vista==0)
      {         
            archivo = cadenaD;
            //System.out.println(cadenaD);
            img= new GreenfootImage(cadenaD);
      }
      else if(vista==1)
      {
            
          archivo = cadenaI; 
          //System.out.println(cadenaI);
          img= new GreenfootImage(cadenaI);
      } 
            //  System.out.println("ARCH"+archivo);
   }
   
       /** Efectua el movimiento del enemigo respecto a sus limites
      */
   public void move(String archivo,int tamX, int tamY,String imaIzq,String imaDer,int numSpr, int limIzq, int limDer)
    {
        World mundo = (WorldMo) getWorld();
        int positionX,positionY;
        positionX=getX();
        positionY=getY(); 
       
       
      spriteNormal(archivo,tamX,tamY,imaIzq,imaDer,numSpr);
      move(Band);

      if(/*Dx>=550*/ positionX>=limDer && vista ==0)
      {
          vista=1;
          Band=-1;
         
          Tlado=1; 
          Clado=1;
          contSky=1;
           //System.out.println("A:"+Tlado);
      }
      
      if(/*Dx<=50*/ positionX<=limIzq   && vista ==1 )
      {
         vista=0;
         Band=1;
         Tlado=2;
           contSky=2;
         //Tlado++;
      }
      
     
      
      if(contSky==1)//8 con band = 1, 12 con band=3
      {
          // mundo.addObject(new Ball(),Greenfoot.getRandomNumber(550),getY()+10);
           //System.out.println("SKY1: "+contSky);
           contSky=0;
         
      }
      
      if(contSky==2)//4 ,asi funcionan todas las posiciones
           {
              //mundo.removeObject(Ball.class); 
              // System.out.println("CIEL2 :"+contSky);

             // mundo.removeObjects(mundo.getObjects(Ball.class));
           }
   } 
       /**  una bandera para verificar con el enemigo Tierra
      */
    public int getTlado()
    {
        
        return Tlado;
    
    }
        /**  una bandera para verificar con el enemigo Cielo
      */
      public int getClado()
    {
        
        return Clado;
    
    }
}