import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Cuerpo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cuerpo extends Heroe
{
    /**
     * Act - do whatever the Cuerpo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
   private int posY=0; /*Imagen Actual en el sprite sheet cuando camina*/
    private int tamX=40,tamY=53; /*Altura y Anchura del personaje*/
    private int posX=0,posX2; /*Imagen Actual en el sprite sheet cuando ataca*/

    
    private int numSpr=6,cont=0,speed=8,vista,bandB=1;
   
    private GreenfootImage img;
    private GreenfootImage sprite;
   
    private String archivo = "Naruto/WRight.png";
    
    
    private Record record =new Record();
    private   double disY = 0;
    private double g = 1;
    private  double med_vel = -6;
    private boolean bandSalto;
    
    private int BandKey=0;
    private int ifgetKey=0;
    private int lvl;
    
    private WorldMo m;
    
   private Counter vidas;  
   private int vida=1000;  
   private int numVidas=2;  
   private static final int DISV1 =500;  
   private static final int DISV2 =500;
    private int z=0;
    private int bandF=0;
    
    public Cuerpo()
    {
        img = new GreenfootImage(archivo);
        sprite = new GreenfootImage(tamX,tamY);
        sprite.drawImage(img,0,0);
        setImage(sprite);
        lvl=1;
        vidas = new Counter ("Vidas: ");
        vidas.setValue(numVidas); 
        //m.addObject(new Vida(3,1000), 400,20);
        
    } 
    
    public void act() 
    {
       move();
       modificaBarrera();
       super.verificaT();
       avanzaNivel();
       disminuyeVidas();
       verifExtremo();
    }
    
 
   
    
      
    
    
    public void move()
    {
        int positionX,positionY;
        positionX=getX();
        positionY=getY(); 
        
        if(Greenfoot.isKeyDown("Right"))
        {
            vista=0;
            spriteNormal();
            setLocation(positionX+5,positionY);
        }
        
         if(Greenfoot.isKeyDown("Left"))
        {
            vista=1;
            spriteNormal();
            setLocation(positionX-5,positionY);
        }
        
        if(Greenfoot.isKeyDown("up") )
         {
            if(bandSalto)
            {
                disY = med_vel;
                bandSalto = false;   
            }
            setLocation(positionX,(int)(positionY + disY));
         }
        
        vidas.move(positionX,positionY-50) ;
    } 
    
     public void verifExtremo()
     {
        if(disY<50 && getY()<=575 )//575
        {
             if(boom==1)
             {
                 //setLocation(getX(),370); 
                 setLocation(Hx,Hy-27);
                 bandSalto = true;
             }
             else
             {
                 disY = disY + (g/3);
                 setLocation(getX(),(int)(getY()+disY));
             }
         }
         else
         {
           disY=50;
           setLocation(getX(),571); //575
           bandSalto = true;
        }       
        //System.out.println("cuerpo"+getY());
     }
    
    public void spriteNormal()
    {
        img = new GreenfootImage(archivo);
        GreenfootImage sprite = new GreenfootImage(tamX,tamY);
        //si el contador es mayor a la velocidad de animacion se cambia a la imagen siguiente
       RevisaVista();
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
      
   public void RevisaVista()
   {
      if(vista==0)
      {
            archivo = "Naruto/"+"WRight.png";
      }
      if(vista==1)
      {
            archivo = "Naruto/"+"WLeft.png"; 
      } 
       
   }
    
    
     /**Verifica  la la cntidad de llaves que va recolectando el heroe
      */
    public int verifKey(int n)
    {
      
         if(isTouching(Key.class))
         {
             
             removeTouching(Key.class);
             BandKey++;
             if(BandKey==n)
             {
             
              System.out.println("Ya no hay LLAVES");
             
             ifgetKey=1;
            } 
            
         }
         
         
        //System.out.println("BAND :"+BandKey);
          //System.out.println("TOTK :"+TotKey);
          //  System.out.println("TOTK :"+ifgetKey);
         return ifgetKey; 
    }
    
    public void avanzaNivel()
    {
      
       if(lvl==1 && verifKey(3)==1)
        {    
           m= (WorldMo)getWorld();
            
          
           m.nivel2();
           
           ifgetKey=0;
            BandKey=0;
            bandB=1;
           lvl=2;
        }
           //System.out.println("BAND2 :"+BandKey);
               /*System.out.println("LVL :"+lvl);
                  System.out.println("TOTKAAAAAAA :"+ifgetKey);
      */
       
       if (lvl==2 && verifKey(4)==1)
       {
             m= (WorldMo)getWorld();
             // System.out.println("QUE Siempre no :");
             m.nivel3();
             lvl=3;
             ifgetKey=0;
             BandKey=0;
       }
        
       if (lvl==3 && verifKey(5)==1)
       {
             m= (WorldMo)getWorld();
        //System.out.println("QUE pedo :");
        Greenfoot.stop();
       }
    }
    
    public void disminuyeVidas()
   {
       WorldMo m = (WorldMo) getWorld(); 
       
            if(vida<=1000 && vida>0)
            {
                if(isTouching(Comun.class))
                {
                 //System.out.println(vida);
                 vida=vida-DISV1;  
                 setLocation(60,1450);
                 bandTE=1;
                }
                else if(isTouching(Ball.class))
                {
                  vida=vida-DISV1; 
                   m.removeObjects(m.getObjects(Ball.class));
                  //removeTouching(Ball.class); 
                  //System.out.println(vida);
                }
                else if(lvl==1)
                {
                  if(isTouching(Bomb.class))
                  {
                      vida=vida-DISV1; 
                       m.removeObjects(m.getObjects(Bomb.class));
                       //removeTouching(Bomb.class); 
                      //System.out.println(vida);
                  }
                }
                 else if(isTouching(Rock.class))
                {
                   vida=vida-1500; 
                   m.removeObjects(m.getObjects(Rock.class));
                   //se posiciona el heroe en otro lugar
                  // removeTouching(Rock.class);
                 
                   //System.out.println(vida);
                }
                
                  else if(isTouching(BSky.class))
                {
                   vida=vida-1500; 
                   
                   //se posiciona el heroe en otro lugar
                   //removeTouching(BSky.class);
                   m.removeObjects(m.getObjects(BSky.class));
                 
                  // System.out.println(vida);
                }
                  else if(isTouching(BFire.class))
                {
                   vida=vida-1500; 
                   
                   //se posiciona el heroe en otro lugar
                   //removeTouching(BFire.class);
                   m.removeObjects(m.getObjects(BFire.class));
                 
                  // System.out.println(vida);
                }
                
             
                else if(isTouching(Tierra.class))
                {
                    vida=vida-DISV2; 
                    setLocation(60,1450);
                    bandTE=1;
                    //System.out.println(vida);
                }
                else if(isTouching(Cielo.class))
                {
                   vida=vida-DISV2;  
                   setLocation(60,1450);
                   bandTE=1;
                  // System.out.println(vida);
                }
                else if(isTouching(Fuego.class))
                {
                   vida=vida-DISV2;  
                   setLocation(60,1450);
                   bandTE=1;
                   //System.out.println(vida);
                }
                 System.out.println("VIDA : "+ vida);
            }
            
            if( vida<=0 &&  vidas.getValue()>0 )
            {
               vidas.setValue( vidas.getValue() - 1);
          
               if(vidas.getValue()<=0)
               {
                   //mundo.addObject(message,250,100);
                   //Greenfoot.delay(200);
                  
                   //BJ.detenMusica();
                   //Greenfoot.setWorld(new Menu());  
                   WorldMo mun = (WorldMo) m;
                   int a=mun.GetTime();
                   record.comparaPuntaje(a);
                   System.out.println("YA MUDIO  ");
                   //Greenfoot.stop();
                   Greenfoot.setWorld(new WorldMo());
                }
               
               vida=1000;
            }
            /*m.removeObjects(m.getObjects(Vida.class));
            m.addObject(new Vida(vidas.getValue(),vida), 400,20);*/
   }
   
   public void modificaBarrera()
   {
       World m = (WorldMo)getWorld();
       
       if(lvl==1 && bandB==1)
       {
           m.addObject(vidas, getX(), getY());
           m.addObject(new barrV(),790,750);
           bandB=0;
       }
       if(lvl==1 && BandKey==2 &&  bandF==0)
       {
             m.addObject(new JefeT(100,600),400, 65);
             bandF=10;
       }
       
        else if(lvl==2 && bandB==1)
                {
                    m.addObject(new barrV(),790,750);
                      m.removeObjects(m.getObjects(JefeT.class));
                    bandB=0;
                }
       if(lvl==2 && BandKey==2)
       {
           if(bandB==0)
           {
               m.removeObjects(m.getObjects(barrV.class));
               
               List listaComun = this.m.getObjects(Comun.class); 
               this.m.removeObjects(listaComun);
               bandB=2;
           }
           if(lvl==2 &&bandB==2)
           {
               m.addObject(new Ej(), 1250, 1160);
               m.addObject(new Ej(), 1700, 1160);
               m.addObject(new Ej(), 1550, 1450);
               m.addObject (new Cielo(200,600), 1500, 1160);
               bandB=3;
           }
           if(isTouching(Ej.class) && bandB==3)
           {
               m.addObject(new barrV(),1050,750);
               m.addObject(new barrV(),1900,750);
           }
       }
       if(lvl==2 && BandKey==3 && bandB==3)
       {
           m.removeObjects(m.getObjects(barrV.class));
           m.removeObjects(m.getObjects(Ej.class));
           m.removeObjects(m.getObjects(Cielo.class));
           m.addObject(new Ej(), 2000, 1450);
           bandB=4;
       }
       if(isTouching(Ej.class) && bandB==4)
       {
           bandB=5;
       }
       if(lvl==2 && bandB==5)
       {
           m.addObject(new barrV(),1500,750);
           m.addObject(new JefeC(750,610),2210,750);
           m.addObject(new Key(), 1700, 1000);
           bandB=6;
       }
       if(lvl==3 && bandB==6)
       {
           m.removeObjects(m.getObjects(JefeC.class));
           m.removeObjects(m.getObjects(barrV.class));
           m.removeObjects(m.getObjects(Ej.class));
           bandB=0;
           bandF=0;
       }
       
       ///*****************/////////////
       
       if(lvl==3 && bandF==0)
       {
           m.addObject(new barrV(),1500,750);
           bandF=1;
           
        }
       if(lvl==3 && bandF==1 && BandKey==1)
       {
          m.removeObjects(m.getObjects(barrV.class)); 
          m.removeObjects(m.getObjects(Comun.class)); 
          bandF=2;
       } 
       
       if(lvl==3 && bandF==2)
       {
        m.addObject(new Ej(), 1550, 1450);
        
        bandF=3;  
       }
       
       if(isTouching(Ej.class) && bandF==3)
           {
               m.addObject(new barrV(),1050,750);
               m.addObject(new barrV(),1900,750);
               m.addObject(new Comun(100,600), 1350, 1050);
               m.addObject(new Comun(100,600), 1150, 1400);
               bandF=11;
           }
       if(lvl==3 && bandF==11 && BandKey==2)
       {
           m.removeObjects(m.getObjects(barrV.class));
           m.removeObjects(m.getObjects(Ej.class)); 
           m.removeObjects(m.getObjects(Comun.class)); 
           m.addObject(new Ej(), 150, 1450);
           bandF=4;
           
       }
        if(isTouching(Ej.class) && bandF==4)
       {
           m.addObject(new barrV(),790,750);
           m.addObject(new Comun(100,600), 350, 1000);
           m.addObject(new Comun(100,600), 780, 1300);
           bandF=5;
       }
       if(lvl==3 && bandF==5 && BandKey==3 )
       {
           m.removeObjects(m.getObjects(barrV.class));
           m.removeObjects(m.getObjects(Ej.class));
           m.removeObjects(m.getObjects(Comun.class)); 
           m.addObject(new Ej(), 2000, 1450);
           bandF=6;
       }
         if(isTouching(Ej.class) && bandF==6)
       {
           m.removeObjects(m.getObjects(barrH.class));
           m.addObject(new barrV(),1500,750); 
           
            bandF=7;
       }
       
       if(lvl==3 && BandKey==4 && bandF==7)
       {
            m.addObject(new JefeF(300,660),1900,100); 
            bandF=8;
        }
       if( BandKey==5  &&  bandF==8 )
       {
           m.removeObjects(m.getObjects(JefeF.class)); 
           bandF=9;
       }
   }
  
}
