import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Font;
import java.awt.Color;

/**
 * Write a description of class Mensaje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Texto extends Actor
{
    private String texto;
    private Color color;
    private int ancho = 410;
    private int alto = 300;
    
    /**
     * Constructor de la clase Mensaje
     */
    public Texto (String UnTexto,Color UnColor)
    {
        texto=UnTexto;
        color=UnColor;
        actualizaImagen();        
    }
    
    /**
     * Metodo que actualiza la imagen del mensaje
     */
    public void actualizaImagen()
    {
        Font fuente = new Font("Arial",Font.BOLD,20);       
        GreenfootImage imagen = new GreenfootImage(ancho,alto);
        imagen.setFont(fuente);
        imagen.setColor(color);
        imagen.drawString(texto, 10,16);
        setImage(imagen);
    }
    
    /**
     * Metodo que actualiza el texto del mesaje
     */
    public void ponTexto(String texto)
    {
        this.texto=texto;
        actualizaImagen();
    }
    
}
