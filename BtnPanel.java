import javax.swing.*;
import java.awt.*;

public class BtnPanel extends JPanel{

    private JRadioButton ai;
    private JRadioButton pvp;
    private JButton[] btns = new JButton[3];
    private String[] btnStrs = {"开始游戏", "悔棋", "退出"};

    public JButton[] getBtns(){
        return btns;
    }

    public JRadioButton[] getModelForm(){
        return new JRadioButton[]{ai, pvp};
    }

    public BtnPanel(GoListener gol){
        for(int i = 0; i < btnStrs.length; i++){
            JButton btn = new JButton (btnStrs[i]);
            this.add (btn);
            btn.setBackground (Color.WHITE);
            btn.setPreferredSize (new Dimension (95, 35));
            btn.addActionListener (gol);
            btns[i] = btn;
        }
        ai = new JRadioButton ("人机对战");
        pvp = new JRadioButton ("人人对战");
        ButtonGroup group = new ButtonGroup ();
        group.add (ai);
        group.add (pvp);
        this.add (ai);
        this.add (pvp);
        pvp.setSelected (true);// 默认选择的
        this.setPreferredSize (new Dimension (100, 0));
    }
}
