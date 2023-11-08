package org.example;

import java.awt.*;

public class Apple {
    private static final int DIAMETER = 18;
    private int x;
    private int y;

    Game game;

    public Apple(Game game){
        this.game = game;
        applePosition();
    }

    public void paint(Graphics2D graphics){
        graphics.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public void applePosition(){
        x = (int) (Math.random()*(game.snake.SNAKESIZE-1))*game.snake.SNAKESIZE+1;
        y = (int) (Math.random()*(game.snake.SNAKESIZE-1))*game.snake.SNAKESIZE+1;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
