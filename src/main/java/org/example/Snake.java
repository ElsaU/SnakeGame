package org.example;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake {
    public static final int SNAKESIZE = 20;
    private int x = 1;
    private int y = 21;
    private int xd = SNAKESIZE;
    private int yd = 0;
    Game game;
    ArrayList<Coordinates> snakeBody;

    public Snake(Game game){
        this.game = game;
        snakeBody = new ArrayList<>();
    }

    public void paint(Graphics2D graphics){
        graphics.fillRect(x, y, SNAKESIZE, SNAKESIZE);

        for (int i=0; i < snakeBody.size(); i++) {
            Coordinates snakePart = snakeBody.get(i);
            graphics.fillRect((snakePart.getX()), snakePart.getY(), SNAKESIZE, SNAKESIZE);
        }
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
        if (x <= 0 || x + SNAKESIZE >= game.getWidth() || y <= 0 || y + SNAKESIZE-1 >= game.getHeight() || bodyCollision()){
            game.gameOver();
        }

        if (appleCollision()){
            snakeBody.add(new Coordinates(x, y));
            game.upgradeScore();
            game.apple.applePosition();
        }

        paintTail();

        x = x + xd;
        y = y + yd;
    }

    private void paintTail(){
        for (int i=snakeBody.size()-1; i >= 0 ; i--) {
            if (i == 0){
                snakeBody.get(i).setX(x);
                snakeBody.get(i).setY(y);
            }else {
                snakeBody.get(i).setX(snakeBody.get(i-1).getX());
                snakeBody.get(i).setY(snakeBody.get(i-1).getY());
            }
        }
    }

    public Boolean appleCollision(){
        return game.apple.getBounds().intersects(getBounds());
    }

    public Boolean bodyCollision(){
        Boolean collision = false;
        for (int i = 1; i < snakeBody.size(); i++){
            if (snakeBody.get(i).getX() == x && snakeBody.get(i).getY() == y){
                collision = true;
            }
        }
        return collision;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, SNAKESIZE, SNAKESIZE);
    }

}
