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
        int xa;
        int ya;
        do {
            xa = (int) (Math.random()*(game.snake.SNAKESIZE-1))*game.snake.SNAKESIZE+1;
            ya = (int) (Math.random()*(game.snake.SNAKESIZE-1))*game.snake.SNAKESIZE+1;
        }while (snakeBodyPosition(xa, ya) == true);

        x = xa;
        y = ya;
    }

    public Boolean snakeBodyPosition(int xa, int ya){
        Boolean collision = false;
        for (int i = 1; i < game.snake.snakeBody.size(); i++){
            if (game.snake.snakeBody.get(i).getX() == xa && game.snake.snakeBody.get(i).getY() == ya){
                collision = true;
            }
        }
        return collision;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
