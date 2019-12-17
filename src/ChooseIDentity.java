import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChooseIDentity extends JFrame{
    private JButton userButton;
    private JButton adminButton;
    private JPanel root;
    private Main main;

    public ChooseIDentity(Main main) {
        add(root);
        setTitle("The Library");
        setSize(400, 150);
        this.main = main;
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setUserFirstPage(ChooseIDentity.this);
            }
        });

    }
}
