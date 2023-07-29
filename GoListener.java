import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GoListener extends MouseAdapter implements ActionListener, GoData{


    JRadioButton[] modelForm;

    String gameModel = "pvp";// 人机 人人

    int chessFlag;// 0 不能下棋 1 黑棋 2 白棋
    Graphics g;

    @Override
    public void actionPerformed(ActionEvent e){

        if(modelForm[0].isSelected ()){
            gameModel = "pve";
        } else if(modelForm[1].isSelected ()){
            gameModel = "pvp";
        }
        String btnStr = e.getActionCommand ();
        JButton btn = (JButton) e.getSource ();
        if(btnStr.equals ("开始游戏")){
            btn.setText ("结束对局");
            chessFlag = 1;
        } else if(btnStr.equals ("悔棋")){
            // 悔棋

        } else if(btnStr.equals ("退出")){
            System.exit (0);
        } else if(btnStr.equals ("结束对局")){
            btn.setText ("开始游戏");
            chessFlag = 0;
        }


    }

    @Override
    public void mousePressed(MouseEvent e){

        int x = e.getX ();
        int y = e.getY ();
        if(chessFlag == 0){
            JOptionPane.showConfirmDialog
                    (null, "请先开始游戏", "提示", JOptionPane.DEFAULT_OPTION);
            return;
        }
//        System.out.println("x:" + x + " y:" + y);
        // 求行列值
        int r = (y - Y + SIZE / 2) / SIZE; // 行
        int c = (x - X + SIZE / 2) / SIZE; // 列
//        System.out.println (r + " " + c);
        if(x < 25 || y < 25 || r < 0 || r >= ROWS || c < 0 || c >= COLS){
            JOptionPane.showMessageDialog (null, "请下在棋盘内", "提示", JOptionPane.DEFAULT_OPTION);
            return;
        }
        if(chessArr[r][c]!=0){
            JOptionPane.showMessageDialog (null, "此处已有棋子", "提示", JOptionPane.DEFAULT_OPTION);
            return;
        }
        if(gameModel.equals ("pvp")){

            // 存储棋子
            chessArr[r][c] = chessFlag;

            boolean ifwin = ChessJudge.checkWin(r, c, chessFlag);
            System.out.println("ifwin:" + ifwin);

            if(chessFlag == 1){
                g.setColor (Color.BLACK);
                chessFlag = 2;
            } else{
                g.setColor (Color.WHITE);
                chessFlag = 1;
            }
            // 还原坐标
            int chessX = X + c * SIZE - SIZE / 2;
            int chessY = Y + r * SIZE - SIZE / 2;
            g.fillOval (chessX, chessY, SIZE, SIZE);

            // 判断输赢

        } else{

        }
    }
}
