import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GoPanel extends JPanel implements GoData{

    GoListener gol;

    public BufferedImage getBG(){
        File file = new File ("imgs/gobg.png");
        BufferedImage buffImage = null;
        try {
            buffImage = ImageIO.read (file);
        } catch (IOException e) {
            System.out.println("Image not found!");
        }
        System.out.println(buffImage);
        return buffImage;
    }

    public GoPanel(GoListener gol){
        this.gol = gol;
        this.addMouseListener (gol);
        this.addMouseMotionListener (gol);
    }

    @Override
    public void paint(Graphics g){

        Graphics2D g2d = (Graphics2D) g;
        float transparency = 0.5f; // Change this value to adjust the transparency

        // Create an AlphaComposite object with the desired transparency
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency);
        g2d.setComposite(alphaComposite);

        // Draw the image with the applied transparency
        g2d.drawImage (getBG (), 0, 0, getWidth (), getHeight (), null);

        g.setColor (Color.RED);
        g.drawRect (X - 25, Y - 25, COLS * SIZE , ROWS * SIZE);
        // 画棋盘
        g.setColor (Color.ORANGE);
        for(int i = 0; i < ROWS; i++){
            g.drawLine (X, Y + i * SIZE, X + (COLS - 1) * SIZE, Y + i * SIZE);
        }

        for(int i = 0; i < COLS; i++){
            g.drawLine (X + i * SIZE, Y, X + i * SIZE, Y + (ROWS - 1) * SIZE);
        }

        // 遍历数组绘制棋子
        for(int i = 0; i < chessArr.length; i++){
            for(int j = 0; j < chessArr[i].length; j++){
                int chessFlag = chessArr[i][j];
                if(chessFlag!=0){
                    g.setColor (chessFlag==1?Color.BLACK:Color.WHITE);
                    int chessX = X + j * SIZE - SIZE / 2;
                    int chessY = Y + i * SIZE - SIZE / 2;
                    g.fillOval (chessX, chessY, SIZE, SIZE);
                }
            }
        }

    }
}
