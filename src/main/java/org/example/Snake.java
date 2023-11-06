package org.example;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Snake {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private int x = 250;
    private int y = 250;
    private int xd = 1;
    private int yd = 0;
    Game game;

    public Snake(Game game){
        this.game = game;
    }

    public void paint(Graphics2D graphics){
        graphics.fillRect(x, y, WIDTH, HEIGHT);
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_LEFT && xd == 0){
            xd = -1;
            yd = 0;
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT && xd == 0){
            xd = 1;
            yd = 0;
        }else if (e.getKeyCode() == KeyEvent.VK_UP && yd == 0){
            xd = 0;
            yd = -1;
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN && yd == 0){
            xd = 0;
            yd = 1;
        }
    }

    public void move(){
        x = x + xd;
        y = y + yd;

        if (x == 0 || x + WIDTH == game.getWidth() || y == 0 || y + HEIGHT == game.getHeight()){
            game.gameOver();
        }

        if (collision()){
            game.upgradeScore();
            game.apple.applePosition();
            upgradeSnake();
        }
    }

    private void upgradeSnake() {

    }

    public Boolean collision(){
        return game.apple.getBounds().intersects(getBounds());
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

}
