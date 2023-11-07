package org.example;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Snake {
    public static final int SNAKESIZE = 20;
    private int x = 1;
    private int y = 1;
    private int xd = SNAKESIZE;
    private int yd = 0;
    Game game;

    public Snake(Game game){
        this.game = game;
    }

    public void paint(Graphics2D graphics){
        graphics.fillRect(x, y, SNAKESIZE, SNAKESIZE);
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_LEFT && xd == 0){
            xd = -SNAKESIZE;
            yd = 0;
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT && xd == 0){
            xd = SNAKESIZE;
            yd = 0;
        }else if (e.getKeyCode() == KeyEvent.VK_UP && yd == 0){
            xd = 0;
            yd = -SNAKESIZE;
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN && yd == 0){
            xd = 0;
            yd = SNAKESIZE;
        }
    }

    public void move(){
        x = x + xd;
        y = y + yd;

        if (x <= 0 || x + SNAKESIZE >= game.getWidth() || y <= 0 || y + SNAKESIZE-1 >= game.getHeight()){
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
        return new Rectangle(x, y, SNAKESIZE, SNAKESIZE);
    }

}
