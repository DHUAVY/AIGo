import javax.swing.*;
import javax.swing.plaf.synth.ColorType;
import java.awt.*;

public class GoUI extends JFrame{

    public static void main(String[] args){
        new GoUI ();
    }

    GoListener gol = new GoListener ();

    public GoUI(){
        setTitle ("GoBang");
        setSize (950, 850);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        GoPanel goPanel = new GoPanel (gol);
        BtnPanel btnPanel = new BtnPanel (gol);

        add (goPanel, BorderLayout.CENTER);
        add (btnPanel, BorderLayout.WEST);

        setVisible (true);

        gol.g = goPanel.getGraphics ();
        gol.modelForm = btnPanel.getModelForm ();

    }


}
