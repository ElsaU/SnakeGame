package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel{
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    Apple apple = new Apple(this);
    Snake snake = new Snake(this);

    private int score = 0;

    public Game(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                snake.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        setFocusable(true);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Snake Game");
        Game game = new Game();
        game.setBackground(Color.BLACK);
        frame.add(game);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true){
            game.move();
            game.repaint();
            Thread.sleep(150);
        }

    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
/*
        for (int i = 0; i<WIDTH/snake.SNAKESIZE; i++){
            graphics.drawLine(0, i*snake.SNAKESIZE, WIDTH, i*snake.SNAKESIZE);
            graphics.drawLine(i*snake.SNAKESIZE, 0, i*snake.SNAKESIZE, HEIGHT);
        }
*/
        graphics.setColor(Color.RED);
        apple.paint(graphics);
        graphics.setColor(Color.GREEN);
        snake.paint(graphics);

        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        graphics.setColor(Color.WHITE);
        graphics.drawString("Score: "+String.valueOf(score), 8, 20);
    }

    public void move(){
        snake.move();
    }

    public void gameOver(){
        JOptionPane.showMessageDialog(this, "Game Over");
        System.exit(ABORT);
    }

    public void upgradeScore(){
        score++;
    }

}