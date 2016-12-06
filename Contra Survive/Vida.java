import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.Color;

/**
 * Write a description of class Vida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida extends Actor
{
    /**
     * Act - do whatever the Vida wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private Texto mVida;
    private Texto mVidas;
    private WorldMo m;
    
    public Vida(int vidas, int vida)
    {
        //World m = (WorldMo)getWorld();
        int xVidas = vidas;
        int xVida = vida;
        
        mVidas = new Texto("VIDAS : "+xVidas,Color.RED);
        m.addObject(mVidas,20,20);
        
        //mVida = new Texto("VIDA : "+xVida,Color.RED);
        //m.addObject(mVida,750,20);
    }
    
    public void act() 
    {
        // Add your action code here.
        setLocation(400,20);
    }    
}
