package org.example;

import java.awt.*;

public class Apple {
    private static final int DIAMETER = 15;
    private int x = 100;
    private int y = 100;

    Game game;

    public Apple(Game game){
        this.game = game;
    }

    public void paint(Graphics2D graphics){
        graphics.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public void applePosition(){
        x = (int) (Math.random()*game.getWidth()-DIAMETER)+1;
        y = (int) (Math.random()*game.getHeight()-DIAMETER)+1;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
