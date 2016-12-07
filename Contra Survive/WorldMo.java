import greenfoot.*;
import java.util.LinkedList;
import java.util.List;
import java.awt.Color;
/**
 * Crea el los escenarios del juego de acuerdo al nivel  .
 * 
 * @author Anguiano Garcia Alfredo,Juárez Jalomo Ana Paola
 *
 * @version (1.1 Beta)
 */
public class WorldMo extends SWorld
{
    private int y;
    private Boton jugar,ayuda,creditos,volver;
    private LinkedList <GreenfootImage> images;
    private static int Nivel=0;
    private Heroe hro= new Heroe();
    private Cuerpo c= new Cuerpo();
    private int numKey;
    private Fuego fire; 
    private Ej q1; 
    private SimpleTimer timeM;
    private int Tmp=0;
    private Record record =new Record();

    private Counter cont=new Counter("Time : ");

    private Texto mRecord;
    //private Vida VID = new Vida();
    /**
     * Constructor for objects of class WorldMo.
     * 
     */
    public WorldMo()
    {    

        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //super(600, 400, 2); 
        super(800, 600, 1,2300,1500); 

        images = new LinkedList();
        images.add(new GreenfootImage("Boton/B_Jugar.png"));  //0
        images.add(new GreenfootImage("Boton/B_Ayuda.png"));  //1
        images.add(new GreenfootImage("Boton/B_Creditos.png")); //2 

        images.add(new GreenfootImage("Boton/B_volver.png")); //3
        images.add(new GreenfootImage("JCreditos.png")); //4
        images.add(new GreenfootImage("F_2.png")); //5
        images.add(new GreenfootImage("JAyuda.png"));//6
        images.add(new GreenfootImage("EscT1.png"));//7

        jugar = new Boton(getImagen(0));
        ayuda = new Boton(getImagen(1));
        creditos = new Boton(getImagen(2));
        volver=new Boton(getImagen(3));

        addBottom();

        /* Fuego f1 = new Fuego(350,600);
        addObject(f1, 300, 1400,true);
        f1.setLocation(300, 1400);
         */

        q1= new Ej();

        timeM= new SimpleTimer();
        prepare();
    }

    /** Se generan las llaves acorde a una posicion.
     */
    public void AgregaKey(int nKey)
    {
        for(int i=0;i<nKey;i++)
        {
            addObject(new Key(),Greenfoot.getRandomNumber(800),1456);

        }
    }

    /*
    public void SetEsc2()
    {
    GreenfootImage Fg2 = new GreenfootImage("EscF2.png");
    setScrollingBackground(Fg2); 
    }*/

    public void act()
    {

        super.act();

        seleccionar();
        IniTime();
    }

    
    /** Añade los botones del Menu
     */
    public void addBottom()
    {
        setBackground(getImagen(5));

        addObject(ayuda, 100, 350);
        addObject(jugar, 380, 450);
        addObject(creditos, 650, 350);

    }

    /** Regresa el numero de imagen.
     */
    public GreenfootImage getImagen(int n)
    {
        return images.get(n);
    }

    /** Verifica cual boton se selecciona en el Menu.
     */
    public void seleccionar()
    {

        if(Greenfoot.mouseClicked(jugar)) 
        {

            removeObjects(getObjects(null));

            nivel1();
            GreenfootImage Fg = new GreenfootImage("EscT1.png");
            setScrollingBackground(Fg);
            /* 
            nivel3();*/
            //AgregaKey(numKey);
        }
        if(Greenfoot.mouseClicked(creditos)) 
        {

            removeObjects(getObjects(null));
            creditos();
            int a=record.leeArchivo("Records.txt");
            //System.out.println("record "+a);
            mRecord=new Texto("TIEMPO : "+a,Color.RED);
            addObject(mRecord,260,260);

        }
        if(Greenfoot.mouseClicked(ayuda)) 
        {

            removeObjects(getObjects(null));
            ayuda();

        }
        if(Greenfoot.mouseClicked(volver)) {

            removeObjects(getObjects(null));
            addBottom();
        }

    }

    public void IniTime()
    {
        if(timeM.millisElapsed()>0)
        {

            if(timeM.millisElapsed()>1000)
            {
                Tmp++;
                System.out.println("TIME : "+ Tmp);
                timeM.mark();  
            }
        }

    }

    /** Crea el nivel 1 del juego.
     */
    public void nivel1()
    {

        Nivel=1;
        addObject(new Plat2(),1200,120,true);
        prepareT();

        addMainActor(c, 180,900,760,520);
        addObject(hro,180,900);
        c.setLocation(180,900);

        Comun Co1 = new Comun(250,600);
        addObject(Co1, 300, 1470,true);
        Co1.setLocation(300, 1470);

        Comun Co2 = new Comun(100,750);
        addObject(Co2, 470, 650,true);
        Co2.setLocation(470, 650);

        Comun Co3 = new Comun(100,750);
        addObject(Co3, 520, 850,true);
        Co3.setLocation(520, 850);

        Comun Co4 = new Comun(100,750);
        addObject(Co4, 650, 710,true);
        Co4.setLocation(650, 710);

        Comun Co5 = new Comun(100,750);
        addObject(Co5, 150, 420,true);
        Co5.setLocation(150, 420);

        Comun Co6 = new Comun(100,750);
        addObject(Co6, 470, 350,true);
        Co6.setLocation(470, 350);

       
        Tierra t1 = new Tierra(520,750);
        addObject(t1, 560, 1310,true);
        t1.setLocation(560, 1310);

        Tierra t2 = new Tierra(100,770);
        addObject(t2, 580, 565,true);
        t2.setLocation(580, 565);

        numKey=3;  

        Key k1 = new Key();
        addObject(k1, 400, 1180,true);
        k1.setLocation(400, 1180);

        Key k2 = new Key();
        addObject(k2, 100, 1280,true);
        k2.setLocation(100, 1280);

        /*  Key k3 = new Key();
        addObject(k3, 400, 350,true);
        k3.setLocation(400, 550);*/

        Key k3 = new Key();
        addObject(k3, 400, 1350,true);
        k3.setLocation(400,1350);

        /* JefeT T = new JefeT(200,600);
        addObject(T, 400, 65,true);
        T.setLocation(400, 65);*/
    }

    /** Crea el nivel 2 del juego.
     */
    public void nivel2()
    {
        removeObjects(getObjects(barrV.class));
        removeObjects(getObjects(Comun.class));
        removeObjects(getObjects(Tierra.class));
        removeObjects(getObjects(Bomb.class));

        List listaPlataformas = this.getObjects(Plat2.class); 
        this.removeObjects(listaPlataformas);

         
        List listaComun = this.getObjects(Comun.class); 
        this.removeObjects(listaComun);

          
        hro=new Heroe();
        hro.setLocation(300, 1050);

        Nivel=2;
        numKey++;

        addObject (new Comun(100,600), 350, 1400);
        addObject (new Comun(100,650), 150, 1100);
        addObject (new Comun(100,650), 250, 1250);

          
        addObject(new Key(), 300, 980);   
        addObject(new Key(), 480, 1300); 
        addObject(new Key(), 1530, 1090);

        AddPLvl2();

        GreenfootImage Fg = new GreenfootImage("EscC.png");
        setScrollingBackground(Fg);
    }

    /** Crea el nivel 3 del juego.
     */
    public void nivel3()
    {

        //removeObjects(getObjects(Comun.class));
        //removeObjects(getObjects(Cielo.class));
        //removeObject(hro);
        removeObjects(getObjects(JefeT.class));
        List listaPlataformas = this.getObjects(Plat2.class); 
        this.removeObjects(listaPlataformas);

        Nivel=3;
        numKey++;  

        //addMainActor(c, 2100,900,760,520);
        //addObject(hro,2100,900);

        //hro=new Heroe();

        //AgregaKey(numKey);
        addObject(new Key(), 2160, 1050);  
        addObject(new Key(), 1450, 950);  
        addObject(new Key(), 80, 1005); 
        addObject(new Key(), 2100, 220);
        addObject(new Key(), 1990, 360);

        addObject (new Comun(100,600), 1850, 1050);
        addObject (new Comun(100,650), 2050, 950);

       
        AddPLvl3();
        GreenfootImage Fg = new GreenfootImage("EscF1.png");
        setScrollingBackground(Fg);

    }

    /** Añade la imagen de los creditos.
     */

    public void creditos()
    {
        setBackground(getImagen(4));

        addObject(volver, 700, 550);
    }

    /** Añade la imagen de la ayuda.
     */

    public void ayuda()
    {
        setBackground(getImagen(6));

        addObject(volver, 700, 550);
    }

    /** Regresa el numero del nivel.
     */

    public int GetNivel()
    {
        return Nivel;
    } 

    public int GetTime()
    {
        return Tmp;
    }

    public void AddPLvl3()
    {

        
        addObject (new Plat2(), 100, 1425);    //1 
        addObject (new Plat2(), 415, 1285); 
        addObject (new Plat2(), 380, 1425); 
        addObject (new Plat2(), 275, 1205); 

        addObject (new Plat2(), 560, 1335);
        addObject (new Plat2(), 640, 1335);

        addObject (new Plat2(), 220 , 1350);
        addObject (new Plat2(), 720, 1335);

        addObject (new Plat2(), 720, 1225);
        addObject (new Plat2(), 560, 1225);

        addObject (new Plat2(), 130, 1140);
        addObject (new Plat2(), 640, 1130);

        addObject (new Plat2(), 395, 1125);

        addObject (new Plat2(), 640 , 1050);
        addObject (new Plat2(), 70, 1050);
        addObject (new Plat2(), 765, 1000);
        addObject (new Plat2(), 290, 1350);


        
       
        addObject (new Plat2(),900 , 1350);
        addObject (new Plat2(),980, 1350);
        addObject (new Plat2(),1320, 1295);
        addObject (new Plat2(),1485, 1295);
        addObject (new Plat2(),1145, 1425);

        addObject (new Plat2(), 1120, 1255);//1111
        addObject (new Plat2(), 1235, 1425);
        addObject (new Plat2(), 1480, 1200);
        addObject (new Plat2(), 1310, 1200);
        addObject (new Plat2(),1395, 1200);
        addObject (new Plat2(),1470, 1000);

        addObject (new Plat2(), 1580, 1125);//
        addObject (new Plat2(), 1145, 1125);

        addObject (new Plat2(), 1065, 1125);
        addObject (new Plat2(), 985, 1045);
        addObject (new Plat2(), 1310, 1045);

        addObject (new Plat2(),1475, 1200);
        addObject (new Plat2(),1700, 1180);//
        addObject (new Plat2(),1795, 1275);
        addObject (new Plat2(),1960, 1000);//
        addObject (new Plat2(),1710, 1350);
        addObject (new Plat2(),1960, 1350);
        addObject (new Plat2(),1795, 1425);
        addObject (new Plat2(),1875, 1425);
        addObject (new Plat2(),1955, 1125);
        addObject (new Plat2(),1875, 1125);
        addObject (new Plat2(),1955, 1425);
        addObject (new Plat2(),1795, 1425);
        /*PLATAFORMAS PARTE HORIZONTAL HASTA AQUI */

        
        
     
        addObject (new Plat1(),2000, 350);
        addObject (new Plat1(),1600, 900);
        addObject (new Plat1(),1800, 800);
        addObject (new Plat1(),2200, 700);

        
        addObject (new Plat2(),1880, 900);//
        addObject (new Plat2(),2300, 825);
        addObject (new Plat2(),1570, 825);

        addObject (new Plat2(),2070, 750);
        addObject (new Plat2(),2190, 675);
        addObject (new Plat2(),1575, 675);

        addObject (new Plat2(),1550, 600);
        addObject (new Plat2(),1610, 600);
        addObject (new Plat2(),1740, 600);
        addObject (new Plat2(),1800, 600);
        addObject (new Plat2(),1850, 600);
        addObject (new Plat2(),1930, 600);
        addObject (new Plat2(),2110, 600);

        addObject (new Plat2(),2070, 600);
        addObject (new Plat2(),2280, 600);

        addObject (new Plat2(),1550, 180);
        addObject (new Plat2(),1620, 180);
        addObject (new Plat2(),1690, 180);
        addObject (new Plat2(),1760, 180);
        addObject (new Plat2(),1830, 180);
        addObject (new Plat2(),1900, 180);
        addObject (new Plat2(),1970, 180);
        addObject (new Plat2(),2040, 180);
        addObject (new Plat2(),2110, 180);
        addObject (new Plat2(),2180, 180);
        addObject (new Plat2(),2250, 180);

        addObject (new Plat2(),1550, 525);//50
        addObject (new Plat2(),1550, 450);
        addObject (new Plat2(),2280, 525);//750

        addObject (new Plat2(),2280, 450);

        addObject (new Plat2(),1580, 225);

        addObject (new Plat2(),1550, 355);
        addObject (new Plat2(),2280, 355);

        
        addObject (new Plat2(),1830, 450);
         
        
       
    }

    
    public void AddPLvl2()
    {
        barrH bH = new barrH();
        addObject(bH,1150,910);

        addObject (new Plat2(), 480, 1425);       
        addObject (new Plat2(), 400, 1425);
        addObject (new Plat2(), 560, 1425);

        addObject (new Plat2(), 640, 1350);
        addObject (new Plat2(), 720, 1350);

        addObject (new Plat2(), 640, 1275);
        addObject (new Plat2(), 560, 1200);
        addObject (new Plat2(), 720, 1275);

        addObject (new Plat2(), 130, 1350);
        addObject (new Plat2(), 230, 1200);
        addObject (new Plat2(), 50 , 1350);
        addObject (new Plat2(), 395, 1125);
        addObject (new Plat2(), 150, 1125);
        addObject (new Plat2(), 640, 1125);
        addObject (new Plat2(), 70 , 1050);
        addObject (new Plat2(), 720, 1050);
        addObject (new Plat2(), 290, 1000);

        addObject (new Plat2(), 900, 1350);
        addObject (new Plat2(),980, 1350);
        addObject (new Plat2(),1320, 1350);
        addObject (new Plat2(),1485, 1275);
        addObject (new Plat2(),1145, 1275);
        addObject (new Plat2(),1240, 1425);

        addObject (new Plat2(), 1160, 1425);
        addObject (new Plat2(), 1480, 1425);
        addObject (new Plat2(), 1310, 1200);
        addObject (new Plat2(), 1390, 1200);
        addObject (new Plat2(),1470, 1200);
        addObject (new Plat2(),1550, 1200);

        addObject (new Plat2(),  1145, 1125);
        addObject (new Plat2(), 1065, 1125);

        addObject (new Plat2(), 985, 1125);
        addObject (new Plat2(), 1310, 1045);
        addObject (new Plat2(), 1475, 1045);

        addObject (new Plat2(),1630, 1200);
        addObject (new Plat2(),1795, 1200);
        addObject (new Plat2(),1960, 1275);
        addObject (new Plat2(),1710, 1050);
        addObject (new Plat2(),1960, 1350);
        addObject (new Plat2(),1795, 1350);
        addObject (new Plat2(),1875, 1425);
        addObject (new Plat2(),1955, 1425);
        addObject (new Plat2(),1875, 1125);
        addObject (new Plat2(),1955, 1125);
        addObject (new Plat2(),1795, 1425);
        addObject (new Plat2(),1715, 1425);

    }

    
    
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepareT()
    {
        //barrV bV = new barrV();
        //addObject(bV,790,750);

        Plat2 plat2 = new Plat2();
        addObject(plat2, 646, 543);
        Plat2 plat22 = new Plat2();
        addObject(plat22, 200, 486);
        Plat2 plat23 = new Plat2();
        addObject(plat23, 719, 426);
        Plat2 plat24 = new Plat2();
        addObject(plat24, 733, 354);
        Plat2 plat25 = new Plat2();
        addObject(plat25, 732, 291);
        Plat2 plat26 = new Plat2();
        addObject(plat26, 733, 198);
        Plat2 plat27 = new Plat2();
        addObject(plat27, 739, 132);
        Plat2 plat28 = new Plat2();
        addObject(plat28, 733, 198);
        Plat2 plat29 = new Plat2();
        addObject(plat29, 739, 132);
        Plat2 plat210 = new Plat2();
        addObject(plat210, 739, 132);
        Plat2 plat211 = new Plat2();
        addObject(plat211, 733, 198);
        Plat2 plat212 = new Plat2();
        addObject(plat212, 739, 132);
        Plat2 plat213 = new Plat2();
        addObject(plat213, 739, 132);
        Plat2 plat214 = new Plat2();
        addObject(plat214, 733, 198);
        Plat2 plat215 = new Plat2();
        addObject(plat215, 739, 132);
        Plat2 plat216 = new Plat2();
        addObject(plat216, 739, 132);
        Plat2 plat217 = new Plat2();
        addObject(plat217, 739, 132);
        Plat2 plat219 = new Plat2();
        addObject(plat219, 739, 132);
        Plat1 plat1 = new Plat1();
        addObject(plat1, 739, 132);
        Plat2 plat220 = new Plat2();
        addObject(plat220, 739, 132);
        Plat2 plat221 = new Plat2();
        addObject(plat221, 733, 198);
        Plat2 plat222 = new Plat2();
        addObject(plat222, 739, 132);
        Plat2 plat223 = new Plat2();
        addObject(plat223, 739, 132);
        Plat2 plat224 = new Plat2();
        addObject(plat224, 733, 198);
        Plat2 plat225 = new Plat2();
        addObject(plat225, 733, 198);
        Plat2 plat226 = new Plat2();
        addObject(plat226, 739, 132);
        Plat2 plat227 = new Plat2();
        addObject(plat227, 733, 198);
        Plat2 plat228 = new Plat2();
        addObject(plat228, 739, 132);
        Plat2 plat229 = new Plat2();
        addObject(plat229, 739, 132);
        Plat2 plat230 = new Plat2();
        addObject(plat230, 733, 198);
        Plat2 plat231 = new Plat2();
        addObject(plat231, 733, 198);
        Plat2 plat232 = new Plat2();
        addObject(plat232, 733, 198);
        Plat2 plat233 = new Plat2();
        addObject(plat233, 739, 132);
        Plat2 plat234 = new Plat2();
        addObject(plat234, 739, 132);
        Plat2 plat235 = new Plat2();
        addObject(plat235, 733, 198);
        Plat2 plat236 = new Plat2();
        addObject(plat236, 733, 198);
        Plat2 plat237 = new Plat2();
        addObject(plat237, 733, 198);
        Plat2 plat238 = new Plat2();
        addObject(plat238, 733, 198);
        Plat2 plat239 = new Plat2();
        addObject(plat239, 739, 132);
        Plat2 plat240 = new Plat2();
        addObject(plat240, 739, 132);
        Plat2 plat241 = new Plat2();
        addObject(plat241, 733, 198);
        Plat2 plat242 = new Plat2();
        addObject(plat242, 733, 198);
        Plat2 plat243 = new Plat2();
        addObject(plat243, 739, 132);
        Plat2 plat244 = new Plat2();
        addObject(plat244, 739, 132);
        Plat2 plat245 = new Plat2();
        addObject(plat245, 733, 198);
        Plat2 plat246 = new Plat2();
        addObject(plat246, 733, 198);
        Plat2 plat247 = new Plat2();
        addObject(plat247, 733, 198);
        Plat2 plat248 = new Plat2();
        addObject(plat248, 733, 198);
        Plat2 plat249 = new Plat2();
        addObject(plat249, 739, 132);
        Plat2 plat250 = new Plat2();
        addObject(plat250, 739, 132);
        Plat2 plat251 = new Plat2();
        addObject(plat251, 733, 198);
        Plat2 plat252 = new Plat2();
        addObject(plat252, 733, 198);
        Plat2 plat253 = new Plat2();
        addObject(plat253, 733, 198);
        Plat2 plat254 = new Plat2();
        addObject(plat254, 733, 198);
        Plat2 plat255 = new Plat2();
        addObject(plat255, 739, 132);
        Plat2 plat256 = new Plat2();
        addObject(plat256, 739, 132);
        Plat2 plat257 = new Plat2();
        addObject(plat257, 733, 198);
        Plat1 plat12 = new Plat1();
        addObject(plat12, 380, 450);
        Plat2 plat259 = new Plat2();
        addObject(plat259, 739, 132);
        Plat2 plat260 = new Plat2();
        addObject(plat260, 739, 132);

        /*Plat3 plat3 = new Plat3(570,600);
        addObject(plat3, 570,600);*/// Esto se debe utilizar para mover las plataformas verticalmente

        //separacion entre oplataformas en x para que queden juntas es de 80
        //separacion para brinco entre plataformas en x es de 165 para salto chingon
        //separacion en y debe se de 75

        plat22.setLocation(320, 1425);
        plat2.setLocation(400, 1425);
        plat23.setLocation(480, 1425);
        plat24.setLocation(145, 1350);
        plat25.setLocation(65, 1350);
        plat26.setLocation(560, 1350);
        plat27.setLocation(640, 1350);
        plat28.setLocation(720, 1350);
        plat29.setLocation(395, 1275);
        plat210.setLocation(230, 1200);
        plat211.setLocation(560, 1200);
        plat212.setLocation(395, 1125);
        plat213.setLocation(150, 1125);
        plat214.setLocation(640, 1125);
        plat215.setLocation(70, 1050);
        plat216.setLocation(720, 1050);
        plat217.setLocation(235, 975);
        plat219.setLocation(525, 975);

        plat1.setLocation(380, 900);//Esta es la plataforma que se debe mover
        plat220.setLocation(720, 825);
        plat221.setLocation(70, 825);
        plat222.setLocation(220, 750);
        plat223.setLocation(570, 750);
        plat224.setLocation(690, 675);
        plat225.setLocation(75, 675);

        plat226.setLocation(30, 600);
        plat227.setLocation(110, 600);
        plat228.setLocation(190, 600);
        plat229.setLocation(270, 600);
        plat230.setLocation(350, 600);
        plat231.setLocation(430, 600);
        plat232.setLocation(510, 600);
        plat233.setLocation(590, 600);
        plat234.setLocation(670, 600);
        plat235.setLocation(750, 600);

        plat236.setLocation(30, 110);
        plat237.setLocation(110, 110);
        plat238.setLocation(190, 110);
        plat239.setLocation(270, 110);
        plat240.setLocation(350, 110);
        plat241.setLocation(430, 110);
        plat242.setLocation(510, 110);
        plat243.setLocation(590, 110);
        plat244.setLocation(670, 110);
        plat245.setLocation(750, 110);

        plat246.setLocation(50, 525);
        plat247.setLocation(50, 450);
        plat248.setLocation(50, 375);
        plat249.setLocation(50, 300);
        plat250.setLocation(50, 225);
        plat251.setLocation(750, 525);
        plat252.setLocation(750, 450);
        plat253.setLocation(750, 375);
        plat254.setLocation(750, 300);
        plat255.setLocation(750, 225);
        plat256.setLocation(130, 375);
        plat257.setLocation(670, 375);

        plat12.setLocation(380, 450);

        plat259.setLocation(285, 200);
        plat260.setLocation(495, 200);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
